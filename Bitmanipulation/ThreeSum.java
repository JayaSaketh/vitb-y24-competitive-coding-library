import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class ThreeSum {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
        }
        //finding the 3 sum
        Arrays.sort(a);
        ArrayList<ArrayList<Integer>> l=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(i>0&&a[i]==a[i-1]) continue;
            int j=i+1;
            int k=n-1;
            while(j<k)
            {
                int sum=a[i]+a[k]+a[j];
                if(sum==0)
                {
                    ArrayList<Integer> t=new ArrayList<>();
                    t.add(a[i]);
                    t.add(a[j]);
                    t.add(a[k]);
                    l.add(t);
                    k--;
                    j++;
                    while(j<k&&a[j]==a[j-1]) j++;
                    while(j<k&&a[k]==a[k+1]) k--;
                }
                else if(sum>0)
                {
                    k--;
                }
                else 
                    j++;
            }
        }
            for(int p=0;p<l.size();p++)
            {
                System.out.print(" { ");
                for(int b=0;b<l.get(p).size();b++)
                {
                    System.out.print(l.get(p).get(b)+" , ");
                }
                System.out.print(" }");
                System.out.println();
            }

        
    }
    
}
