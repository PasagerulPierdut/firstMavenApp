import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
public class PersonService {

    public static List<String> listAllPersonNames(List<Person> listOfPeople) {
        return listOfPeople.stream()
                .map(PersonService::concatenateNames)
         //       .<String>mapMulti((person,  consumer) -> consumer.accept(person.getFirstName() + " " + person.getLastName()))
                .collect(Collectors.toList());
    }

    public static List<Person> listAllMajorPeople(List<Person> listOfPeople) {
        return listOfPeople.stream()
                .filter(person -> person.getAge() >= 18)
                .collect(Collectors.toList());
    }

    public static List<Person> listAllPersonFrom(List<Person> listOfPeople, String city) {
        return listOfPeople.stream()
                .filter(person -> person.getCity().equals(city))
                .collect(Collectors.toList());
    }

    public static List<Person> listAllPersonFrom(List<Person> listOfPeople, String city, String city2) {
        return listOfPeople.stream()
                .filter(person -> person.getCity().equals(city) || person.getCity().equals(city2))
                .collect(Collectors.toList());
    }

    public static List<String> listAllFirstNamesCapitalized(List<Person> listOfPeople) {
        return listOfPeople.stream()
                .map(PersonService::firstNameToUppercase).collect(Collectors.toList());
    }

    public static List<String> listFirstNameFirstLetterFromLastName(List<Person> listOfPeople) {
        return listOfPeople.stream()
                .map(person -> person.getFirstName() + " " + (person.getLastName() == null ? "" : person.getLastName().charAt(0) + "."))
                .collect(Collectors.toList());
    }

    public static List<Person> listAllPeopleBetween18And60(List<Person> listOfPeople) {
        return listOfPeople.stream()
                .filter(person -> person.getAge() >= 18 && person.getAge() <= 60)
                .collect(Collectors.toList());
    }

    public static List<Person> listAllPeopleWhoseFirstNameStartsWithA(List<Person> listOfPeople) {
        return listOfPeople.stream()
                .filter(person -> person.getFirstName().startsWith("A"))
                .collect(Collectors.toList());
    }

    public static List<String> listAllFirstNamesUniquely(List<Person> listOfPeople) {
        return listOfPeople.stream()
                .map(Person::getFirstName)
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<Person> sortPeopleByFirstName(List<Person> listOfPeople) {
        return listOfPeople.stream()
                .sorted(Comparator.comparing(Person::getFirstName))
                .collect(Collectors.toList());
    }

    public static List<Person> sortPeopleByLastName(List<Person> listOfPeople) {
        return listOfPeople.stream()
                .sorted(Comparator.comparing(Person::getLastName, Comparator.nullsLast
                        (Comparator.comparing(Function.identity())))).collect(Collectors.toList());
    }

    public static List<Person> sortPeopleByFirstNameLastNameAge(List<Person> listOfPeople) {
        return listOfPeople.stream()
                .sorted(Comparator.comparing(Person::getFirstName)
                        .thenComparing(Person::getLastName, Comparator.nullsLast(Comparator.comparing(Function.identity())))
                        .thenComparing(Person::getAge)).collect(Collectors.toList());
    }

    private static String firstNameToUppercase(Person person) {
        return person.getFirstName().toUpperCase();
    }

    private static String concatenateNames(Person person) {
        if (person.getLastName() != null && !person.getLastName().equals(" ")) {
            return person.getFirstName() + " " + person.getLastName();
        } else {
            return person.getFirstName() + "";
        }
    }
}
