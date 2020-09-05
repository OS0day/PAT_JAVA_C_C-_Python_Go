import java.util.Arrays;
import java.util.Scanner;

public class Main_1019{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int ans = ds(x)-xs(x);
        if(ans==0){
            System.out.printf("%04d - %04d = %04d\n",ds(x),xs(x),ans);
        }else{
            int n ;
            do{
                n = ds(x)-xs(x);
                System.out.printf("%04d - %04d = %04d\n",ds(x),xs(x),n);
                x = n;

            }while(n!=6174);

        }
    }
    public static int ds (int x){
        int[]a = new int[4];
        a[0] = x/1000;
        a[1] = x/100%10;
        a[2] = x/10%10;
        a[3] = x%10;
        Arrays.sort(a);
        int sum = a[3]*1000+a[2]*100+a[1]*10+a[0];
        return sum;
    }
    public static int xs (int x){
        int[]a = new int[4];
        a[0] = x/1000;
        a[1] = x/100%10;
        a[2] = x/10%10;
        a[3] = x%10;
        Arrays.sort(a);
        int sum = a[0]*1000+a[1]*100+a[2]*10+a[3];
        return sum;
    }
}