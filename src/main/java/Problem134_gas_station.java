public class Problem134_gas_station {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
        }

        if (sum < 0) {
            return -1;
        }

        int result = 0;
        int total = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            if (total < 0) {
                result = i + 1;
                total = 0;
            }
        }
        return result;
    }
}
