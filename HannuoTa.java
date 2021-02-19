package stackForGetMin;

public class HannuoTa {
	
	static int m =0;//标记移动次数
	
    public static void move(int disks,char N,char M)
    {
        System.out.println("第" + (++m) +" 次移动 : " +" 把 "+ disks+" 号圆盘从 " + N +" ->移到->  " + M);
    }
    
    /**
	 * 汉诺塔问题_递归解决
	 * 
	 * （1）     把n-1个盘子由A 移到 B；

　　　（2）     把第n个盘子由 A移到 C；

　　　（3）     把n-1个盘子由B 移到 C；
	 * 
	 * @param n 汉诺塔的层数
	 * @param a 承载最初圆盘的柱子
	 * @param b 起到中转作用的柱子
	 * @param c 移动到的目标柱子
	 */
    public static void hanoi(int n,char A,char B,char C)
    {
        if(n == 1)//圆盘只有一个时，只需将其从A塔移到C塔
            move(1, A, C);//将编号为1的圆盘从A移到C
        else
        {
            hanoi(n - 1, A, C, B);//递归，把A塔上编号1~n-1的圆盘移到B上，以C为辅助塔
            move(n, A, C);//把A塔上编号为n的圆盘移到C上
            hanoi(n - 1, B, A, C);//递归，把B塔上编号1~n-1的圆盘移到C上，以A为辅助塔
        }
    }
    
    public static void main(String[] args) {
		hanoi(5, 'a', 'b', 'c');
	}
}
