import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * by:os0day
 * title:PAT,乙等,1008 数组元素循环右移问题 (20分)
 * date:2020-07-18
 */
/**
 * 1008 数组元素循环右移问题 (20分)
 * 一个数组A中存有N（>0）个整数，在不允许使用另外数组的前提下，将每个整数循环向右移M（≥0）个位置，即将A中的数据由（A
 * ​0
 * ​​ A
 * ​1
 * ​​ ⋯A
 * ​N−1
 * ​​ ）变换为（A
 * ​N−M
 * ​​ ⋯A
 * ​N−1
 * ​​ A
 * ​0
 * ​​ A
 * ​1
 * ​​ ⋯A
 * ​N−M−1
 * ​​ ）（最后M个数循环移至最前面的M个位置）。如果需要考虑程序移动数据的次数尽量少，要如何设计移动的方法？
 *
 * 输入格式:
 * 每个输入包含一个测试用例，第1行输入N（1≤N≤100）和M（≥0）；第2行输入N个整数，之间用空格分隔。
 *
 * 输出格式:
 * 在一行中输出循环右移M位以后的整数序列，之间用空格分隔，序列结尾不能有多余空格。
 *
 * 输入样例:
 * 6 2
 * 1 2 3 4 5 6
 * 输出样例:
 * 5 6 1 2 3 4
 */
public class Main_1008 {


    static Scanner sc = new Scanner(System.in);
    static int inputNumbers,inputM;
    static Stack<Integer> stack = new Stack<Integer>();
    static Queue<Integer> queue = new LinkedList<Integer>();
    public static void main(String[] args) {
        while (sc.hasNext()){
            inputNumbers = sc.nextInt();
            int numbers = inputNumbers;
            inputM = sc.nextInt();
            //将先前的数据清空
            stack = new Stack<Integer>();
            queue = new LinkedList<Integer>();
            if (inputNumbers>100||inputNumbers<1||inputM<0)break;
            while (inputNumbers>0){
                // inputNumberStack(sc.nextInt());
                stack.add(sc.nextInt());
                inputNumbers--;
            }
            System.out.println(stack.toString());
            System.out.println(stack.search(6));
            System.out.println(stack.search(5));

            //继承list的方法 而队列就没有list的方法
            System.out.println(stack.get(0));
            outputNumberQueue(inputM,numbers);
            //    queue.isEmpty()
            while(queue.size()>1){
                System.out.print(queue.poll()+" ");
            }
            System.out.println(queue.poll());
        }
    }

//    static void inputNumberStack(int numbers){
//        stack.add(numbers);
//    }

    static void outputNumberQueue(int M,int N){
        if(M<N){
            while (M>0) {
                queue.add(stack.get(stack.size()-M));
                stack.remove(stack.size()-M);
                M--;
            }
            for(int i = 0; i<stack.size(); i++){
                queue.add(stack.get(i));
            }
        }else {
            if (M%N==0){
                for(int i = 0; i<stack.size(); i++){
                    queue.add(stack.get(i));
                }
            }else {
                M = M/N+1;
                while (M>0) {
                    queue.add(stack.get(stack.size()-M));
                    stack.remove(stack.size()-M);
                    M--;
                }
                for(int i = 0; i<stack.size(); i++){
                    queue.add(stack.get(i));
                }
            }
        }
    }
}
