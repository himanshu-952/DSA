import java.util.Arrays;

public class SavePeopleBoat {
    public int numRescueBoats(int[] people, int limit) {
    Arrays.sort(people);
    int i = 0, j = people.length - 1, boats = 0;
    while (i <= j) {
        if (people[i] + people[j] <= limit) i++;
        j--;
        boats++;
    }
    return boats;
}

}
