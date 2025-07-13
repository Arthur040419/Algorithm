package algorithm;

//860.柠檬水找零
public class LeetCode860 {
    public boolean lemonadeChange(int[] bills) {
        /**
         * 思路：
         * 我们只需要维护5、10、20这三种数据
         * 于是收钱策略为：
         * 1.收到5块，直接收下
         * 2.收到10块，消耗一张5块，收下一张10块
         * 3.收到20块，优先使用一张10块加一张5块找零，如果没有足够的钱满足这种方式，就再选择用三张5块找零
         */

        //表示5块有多少张
        int five = 0;
        //表示10块有多少张
        int ten =0;
        for (int i = 0; i < bills.length; i++) {
            if(bills[i]==5) {
                //情况一
                five++;
            }else if(bills[i]==10){
                //情况二
                ten++;
                five--;
            }else {
                //情况三
                if(ten>0&&five>0){
                    ten--;
                    five--;
                }else {
                    five-=3;
                }
            }
            if(five<0||ten<0){
                return false;
            }
        }
        return true;
    }
}
