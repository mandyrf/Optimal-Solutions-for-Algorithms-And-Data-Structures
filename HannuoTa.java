package stackForGetMin;

public class HannuoTa {
	
	static int m =0;//����ƶ�����
	
    public static void move(int disks,char N,char M)
    {
        System.out.println("��" + (++m) +" ���ƶ� : " +" �� "+ disks+" ��Բ�̴� " + N +" ->�Ƶ�->  " + M);
    }
    
    /**
	 * ��ŵ������_�ݹ���
	 * 
	 * ��1��     ��n-1��������A �Ƶ� B��

��������2��     �ѵ�n�������� A�Ƶ� C��

��������3��     ��n-1��������B �Ƶ� C��
	 * 
	 * @param n ��ŵ���Ĳ���
	 * @param a �������Բ�̵�����
	 * @param b ����ת���õ�����
	 * @param c �ƶ�����Ŀ������
	 */
    public static void hanoi(int n,char A,char B,char C)
    {
        if(n == 1)//Բ��ֻ��һ��ʱ��ֻ�轫���A���Ƶ�C��
            move(1, A, C);//�����Ϊ1��Բ�̴�A�Ƶ�C
        else
        {
            hanoi(n - 1, A, C, B);//�ݹ飬��A���ϱ��1~n-1��Բ���Ƶ�B�ϣ���CΪ������
            move(n, A, C);//��A���ϱ��Ϊn��Բ���Ƶ�C��
            hanoi(n - 1, B, A, C);//�ݹ飬��B���ϱ��1~n-1��Բ���Ƶ�C�ϣ���AΪ������
        }
    }
    
    public static void main(String[] args) {
		hanoi(5, 'a', 'b', 'c');
	}
}
