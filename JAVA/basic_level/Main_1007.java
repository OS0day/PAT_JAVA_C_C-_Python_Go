import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * by:os0day
 * title:PAT,乙等,1007 素数对猜想 (20分)
 * date:2020-07-17
 */

/**
 * 1007 素数对猜想 (20分)
 * 让我们定义d
 * ​n
 * ​​ 为：d
 * ​n
 * ​​ =p
 * ​n+1
 * ​​ −p
 * ​n
 * ​​ ，其中p
 * ​i
 * ​​ 是第i个素数。显然有d
 * ​1
 * ​​ =1，且对于n>1有d
 * ​n
 * ​​ 是偶数。“素数对猜想”认为“存在无穷多对相邻且差为2的素数”。
 *
 * 现给定任意正整数N(<10
 * ​5
 * ​​ )，请计算不超过N的满足猜想的素数对的个数。
 *
 * 输入格式:
 * 输入在一行给出正整数N。
 *
 * 输出格式:
 * 在一行中输出不超过N的满足猜想的素数对的个数。
 *
 * 输入样例:
 * 20
 * 输出样例:
 * 4
 */

public class Main_1007 {

    static Scanner sc = new Scanner(System.in);
    static int inputNumber;
    static List<Integer> numberList = new ArrayList<Integer>();

    public static void main(String[] args) {
        while (sc.hasNext()){
            inputNumber = sc.nextInt();
            if(inputNumber<0||inputNumber>100000){
                break;
            }
            while (inputNumber>1){
                    suShu(inputNumber);
                    inputNumber--;
            }
            //System.out.println(numberList.toString());
            System.out.println(Result(numberList));
        }
    }
    static void suShu(int getNumber){
        int flag = 0;
        for(int i = 2;i < getNumber; i++){
            if((getNumber%i)==0){
                flag = 1;
                break;
            }
        }
        if(flag==0){
            numberList.add(getNumber);
        }
    }
    static int Result(List<Integer> list){
        int count = 0;
        for (int i = 0; i < list.size()-1; i++){
            if((list.get(i)-list.get(i+1))==2){
                count++;
            }
        }
        return  count;
    }

}
