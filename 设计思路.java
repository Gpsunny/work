���ﳵ���˼·
2018��08��17�� 11:24:22 ��������Ӵ �Ķ�����389

    ���빺�ﳵ 
    ���빺�ﳵ���뵽����һ�������¼��ͬʱ���뵽�����У������key�Ǽ�¼��id 
    δ��¼״̬ 
    �û�δ��¼ʱ������빺�ﳵ����productId ��skuId��buyNum ת����json�浽cookie�У�ͬһ����Ʒ��ͬ��skuId��Ϊ������Ʒ����ͬ��skuId��productId��Ϊ��ͬ��Ʒ�����ۼӣ����û���¼�ɹ���ʱ������û�����Ϣ��cookie�е���Ʒ��Ϣ���浽���ݿ��У�Ȼ�����cookie���ݣ���������Ȼ����ֵ�¼�ɹ���ɾ�����ﳵ��ƷȻ���˳������ﳵ����ʾ���� 
    ��¼״̬ 
    ������빺�ﳵ��long userId,long productId,long skuId,int count �浽���У���ͬ��productId��skuId �����ۼӣ���ͬ��skuId����һ�� 
    addToCart(long userId,long skuId,int count); //����sku�����ﳵ��Ʒ
    �޸���Ʒ���� 
    δ��¼״̬ 
    �û�δ��¼ʱ������Ӽ�����������productId��skuId��cooike�н���Ʒ�������мӼ���ע��У��cooike�е���������С��0�����ܴ��ڿ������ 
    ��¼״̬ 
    �û���¼״̬ʱ������Ӽ�����productId��skuId��userId���û����ﳵ��ĳ��sku���������ӻ��ȥdifferֵ��ע��У�������� 
    updateAmount(long userId,skuId,int differ,List selectedSkuIds); //���û����ﳵ��ĳ��sku���������ӻ��ȥdifferֵ���˷���������Ʒ�󣬻����selectedSkuIds���¼���һ�鹺�ﳵ�۸񣬷��������������Ż�ȯ
    ɾ�����ﳵ��¼ 
    δ��¼״̬ 
    �û�δ��¼ʱ������productId��skuIdɾ��cookie�еļ�¼ 
    deleteCart(long userId,long skuId, List selectedSkuIds); //��ĳ��sku���û����ﳵ�Ƴ����˽�Ʒ���������̨���ظ�����selectedSkuIds�۸񣬲��᷵��ѡ�е�sku�б���δѡ�е�sku�б��ϡ�����Ӧ�Ż�ȯ�� 
    ��¼״̬ 
    ��¼״̬�£�ֱ�Ӹ���productId��skuId�Լ�userIdɾ���������� 
    4���ﳵ�б�չʾ 
    δ��¼״̬ 
    ��cookie��ȡ��productId�Լ�skuId�б�չʾ��Ʒ��Ϣ 
    ��¼״̬ 
    ��¼״̬�¸����û�id��ѯ���еļ�¼�� 
    getCart(long userId,list selectedSkuIds); //��ѯ�û����ﳵ���˽ӿڻ����¼���selectedSkuIds��������ѡ����δѡ��sku�б��ϣ�������Ӧ�������������Ż�ȯ��Ϣ��

5.�����ύ�ɹ�����¹��ﳵ�����Լ��޸Ĺ��ﳵ״̬ 
�����ύ�ɹ�����ն����ɹ���Ϣ�����¹��ﳵ״̬������ɾ�������¼

6.��Ʒ�¼ܺ󣬸��¿��״̬����ʾʧЧ 
��Ʒ�¼ܺ������Ϣ�޸Ĺ��ﳵ�����Ʒ״̬ΪʧЧ


ԭ����JDBC 
 /*

   ������ִ��
 * jdbdԭ���������裬
 */
public class Test {
    public static void main(String[] args) throws Exception {
        //ע�����������䷽ʽ����
        Class.forName("com.mysql.jdbc.Driver");
        //����url
        String url = "jdbc:mysql://127.0.0.1:3306/day08";//person�����ݿ��������������ݿ���Ҫ����
        //�����û���
        String username = "root";
        //��������
        String password = "root";
        //������Ӷ���
        Connection con = DriverManager.getConnection(url, username, password);
        //System.out.println(con);
        //���ִ���߶���
        String sql = "select * from phones";
        PreparedStatement ps = con.prepareStatement(sql);
        //��ý����
        ResultSet rs = ps.executeQuery();
        //���������
        while(rs.next()){
            System.out.println(rs.getString("id")+"  "+rs.getString("pinpai")+"  "+rs.getString("xinghao")+"  "+rs.getString("jiage"));
        }
        //�ͷ���Դ
        rs.close();
        ps.close();
        con.close();
    }
}