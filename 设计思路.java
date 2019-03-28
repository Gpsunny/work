购物车设计思路
2018年08月17日 11:24:22 隔壁老王哟 阅读数：389

    加入购物车 
    加入购物车插入到库中一条购物记录，同时插入到缓存中，缓存的key是记录的id 
    未登录状态 
    用户未登录时点击加入购物车，将productId ，skuId，buyNum 转换成json存到cookie中（同一件商品不同的skuId视为两个商品，相同的skuId和productId视为相同商品数量累加），用户登录成功的时候接收用户的消息将cookie中的商品信息保存到数据库中，然后清空cookie数据（京东）不然会出现登录成功后删除购物车商品然后退出，购物车中显示问题 
    登录状态 
    点击加入购物车将long userId,long productId,long skuId,int count 存到库中，相同的productId和skuId 数量累加，不同的skuId新增一条 
    addToCart(long userId,long skuId,int count); //加入sku到购物车商品
    修改商品数量 
    未登录状态 
    用户未登录时，点击加减数量，根据productId和skuId从cooike中将商品数量进行加减，注意校验cooike中的数量不能小于0，不能大于库存数量 
    登录状态 
    用户登录状态时，点击加减数量productId和skuId，userId将用户购物车中某个sku的数量增加或减去differ值，注意校验库存数量 
    updateAmount(long userId,skuId,int differ,List selectedSkuIds); //将用户购物车中某个sku的数量增加或减去differ值。此方法更新商品后，会根据selectedSkuIds重新计算一遍购物车价格，返回满足条件的优惠券
    删除购物车记录 
    未登录状态 
    用户未登录时，根据productId和skuId删除cookie中的记录 
    deleteCart(long userId,long skuId, List selectedSkuIds); //将某个sku从用户购物车移除。此接品，在清除后台会重复计算selectedSkuIds价格，并会返回选中的sku列表与未选中的sku列表集合。及相应优惠券。 
    登录状态 
    登录状态下，直接根据productId和skuId以及userId删除库中数据 
    4购物车列表展示 
    未登录状态 
    从cookie中取出productId以及skuId列表展示商品信息 
    登录状态 
    登录状态下根据用户id查询库中的记录数 
    getCart(long userId,list selectedSkuIds); //查询用户购物车。此接口会重新计算selectedSkuIds，并返回选中与未选中sku列表集合，返回相应的满足条件的优惠券信息。

5.订单提交成功后更新购物车数量以及修改购物车状态 
订单提交成功后接收订单成功消息，更新购物车状态和数量删除缓存记录

6.商品下架后，更新库存状态，显示失效 
商品下架后接收消息修改购物车里的商品状态为失效


原生的JDBC 
 /*

   贾连欲执事
 * jdbd原生开发步骤，
 */
public class Test {
    public static void main(String[] args) throws Exception {
        //注册驱动，反射方式加载
        Class.forName("com.mysql.jdbc.Driver");
        //设置url
        String url = "jdbc:mysql://127.0.0.1:3306/day08";//person是数据库名，连接是数据库须要开启
        //设置用户名
        String username = "root";
        //设置密码
        String password = "root";
        //获得连接对象
        Connection con = DriverManager.getConnection(url, username, password);
        //System.out.println(con);
        //获得执行者对象
        String sql = "select * from phones";
        PreparedStatement ps = con.prepareStatement(sql);
        //获得结果集
        ResultSet rs = ps.executeQuery();
        //结果集处理，
        while(rs.next()){
            System.out.println(rs.getString("id")+"  "+rs.getString("pinpai")+"  "+rs.getString("xinghao")+"  "+rs.getString("jiage"));
        }
        //释放资源
        rs.close();
        ps.close();
        con.close();
    }
}