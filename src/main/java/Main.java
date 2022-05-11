import java.util.List;
public class Main {

    public static void main(String[] args) {

        List<Person> testList = List.of(
                new Person("Old", "Shatterhand", 32, "Hamburg"),
                new Person("Winnetou", null, 36, "Apallaches"),
                new Person("Mary", "Poppins", 24, "London"),
                new Person("Peter", "Pan", 18, "Neverland"),
                new Person("Elvis", "Presley", 43, "Memphis"),
                new Person("Anna", "Szeles", 62, "Oradea"),
                new Person("Eugen", "Paraschiv", 30, "Bucuresti"),
                new Person("Ilinca", "Vandici", 40, "Oradea"),
                new Person("Albert Hernan", "Cortez", 60, "San Cristobal"),
                new Person("Peter", "Bruegel", 32, "Haga"));

        System.out.println(PersonService.listAllPersonNames(testList));

        System.out.println(PersonService.listAllMajorPeople(testList));

        System.out.println(PersonService.listAllPersonFrom(testList, "Oradea"));

        System.out.println(PersonService.listAllPersonFrom(testList, "Oradea", "Hamburg"));

        System.out.println(PersonService.listAllFirstNamesCapitalized(testList));

        System.out.println(PersonService.listFirstNameFirstLetterFromLastName(testList));

        System.out.println(PersonService.listAllPeopleBetween18And60(testList));

        System.out.println(PersonService.listAllPeopleWhoseFirstNameStartsWithA(testList));

        System.out.println(PersonService.listAllFirstNamesUniquely(testList));

        System.out.println(PersonService.sortPeopleByFirstName(testList));

        System.out.println(PersonService.sortPeopleByLastName(testList));

        System.out.println(PersonService.sortPeopleByFirstNameLastNameAge(testList));
    }
}
