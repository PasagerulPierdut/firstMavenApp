import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class PersonServiceTest {
    @Test
    void listFirstPersonNamesWhenListAllPersonNamesIsCalled() {

        //given
        List<Person> exList = List.of(
                new Person("Xc", "xl", 1, "Oradea"),
                new Person("Xr", "xi", 9, "Cluj"),
                new Person("Xhs", "lb", 19, "Cluj"));
        //when
        List result = PersonService.listAllPersonNames(exList);
        //then
        assertThat(result.get(0)).isEqualTo("Xc xl");
    }

    @Test
    void whenListAllMajorPeopleIsCalledOnlyOnePersonIsReturned() {
        //given
        List<Person> exList = List.of(
                new Person("Xc", "xl", 1, "Oradea"),
                new Person("Xr", "xi", 9, "Cluj"),
                new Person("Xhs", "lb", 19, "Cluj"));
        //when
        List result = PersonService.listAllMajorPeople(exList);
        //then
        assertThat(result.size() == 1);
    }

    @Test
    void whenListAllPersonFromItReturnsOnePerson() {
        //given
        List<Person> exList = List.of(
                new Person("Xc", "xl", 11, "Oradea"),
                new Person("Xr", "xi", 9, "Cluj"),
                new Person("Xhs", "lb", 19, "Cluj"));
        //when
        List result = PersonService.listAllPersonFrom(exList, "Oradea");
        //then
        assertThat(result.size() == 1);
    }

    @Test
    void testIfListAllPersonFromReturnsAllRequiredPeople() {
        //given
        List<Person> exList = new ArrayList<>();
        Person p1 = new Person("Xc", "xl", 14, "Oradea");
        Person p2 = new Person("Xr", "xi", 9, "Cluj");
        Person p3 = new Person("Xou", "xam", 9, "Hamburg");
        Person p4 = new Person("Xhs", "lb", 19, "Cluj");
        exList.add(p1);
        exList.add(p2);
        exList.add(p3);
        exList.add(p4);
        //when
        List result = PersonService.listAllPersonFrom(exList, "Oradea", "Cluj");
        //then
        assertFalse(result.contains(p3));
    }

    @Test
    void testIfPersonsNamesAreCapitalized() {
        //given
        List<Person> exList = new ArrayList<>();
        Person p1 = new Person("Xc", "xl", 14, "Oradea");
        Person p2 = new Person("Xr", "xi", 9, "Cluj");
        Person p3 = new Person("Xr", "xi", 9, "Hamburg");
        Person p4 = new Person("Xhs", "lb", 19, "Cluj");
        exList.add(p1);
        exList.add(p2);
        exList.add(p3);
        exList.add(p4);
        //when
        List result = PersonService.listAllFirstNamesCapitalized(exList);
        //then
        assertThat(result.contains("XR"));
    }

    @Test
    void listFirstNameFirstLetterFromLastName() {
        //given
        List<Person> exList = new ArrayList<>();
        Person p1 = new Person("Xc", "xl", 14, "Oradea");
        Person p2 = new Person("Xr", "xi", 9, "Cluj");
        Person p3 = new Person("Xr", "xi", 9, "Hamburg");
        Person p4 = new Person("Xh", "xb", 19, "Cluj");
        exList.add(p1);
        exList.add(p2);
        exList.add(p3);
        exList.add(p4);
        //when
        List<String> result = PersonService.listFirstNameFirstLetterFromLastName(exList);
        String resultString = result.get(1).substring(3, 4);
        //then
        assertTrue(resultString.equals("x"));
    }

    @Test
    void testOnlyPeopleBetween18And60AreListed() {
        //given
        List<Person> exList = new ArrayList<>();
        Person p1 = new Person("Xc", "xl", 14, "Oradea");
        Person p2 = new Person("Xr", "xi", 62, "Cluj");
        Person p3 = new Person("Xr", "xi", 9, "Hamburg");
        Person p4 = new Person("Xhs", "lb", 19, "Cluj");
        exList.add(p1);
        exList.add(p2);
        exList.add(p3);
        exList.add(p4);
        //when
        List result = PersonService.listAllPeopleBetween18And60(exList);
        //then
        assertTrue(result.get(0).equals(p4));
    }

    @Test
    void testIfPeopleStartingWIthAAreAdded() {
        //given
        List<Person> exList = new ArrayList<>();
        Person p1 = new Person("Xc", "xl", 14, "Oradea");
        Person p2 = new Person("Xr", "xi", 9, "Cluj");
        Person p3 = new Person("Ar", "xi", 9, "Hamburg");
        Person p4 = new Person("Xhs", "lb", 19, "Cluj");
        exList.add(p1);
        exList.add(p2);
        exList.add(p3);
        exList.add(p4);
        //when
        List result = PersonService.listAllPeopleWhoseFirstNameStartsWithA(exList);
        Person testPerson = (Person) result.get(0);
        //then
        assertTrue(testPerson.getFirstName().equals("Ar"));
    }

    @Test
    void listAllFirstNamesUniquely() {
        //given
        List<Person> exList = new ArrayList<>();
        Person p1 = new Person("Xr", "xl", 14, "Oradea");
        Person p2 = new Person("Xr", "xi", 9, "Cluj");
        Person p3 = new Person("Xr", "xi", 9, "Hamburg");
        Person p4 = new Person("Xhs", "lb", 19, "Cluj");
        exList.add(p1);
        exList.add(p2);
        exList.add(p3);
        exList.add(p4);
        //when
        List result = PersonService.listAllFirstNamesUniquely(exList);
        //then
        assertTrue(result.size() == 2);
    }

    @Test
    void testIfPeopleAreSortedByFirstname() {
        //given
        List<Person> exList = new ArrayList<>();
        Person p1 = new Person("Ac", "xl", 14, "Oradea");
        Person p2 = new Person("Br", "xi", 9, "Cluj");
        Person p3 = new Person("Xr", "xi", 9, "Hamburg");
        Person p4 = new Person("Chs", "lb", 19, "Cluj");
        exList.add(p1);
        exList.add(p2);
        exList.add(p3);
        exList.add(p4);
        //when
        List result = PersonService.sortPeopleByFirstName(exList);
        //then
        assertTrue(result.get(3).equals(p3));
    }

    @Test
    void sortPeopleByLastName() {
        //given
        List<Person> exList = new ArrayList<>();
        Person p1 = new Person("Xc", "xl", 14, "Oradea");
        Person p2 = new Person("Xr", "bwi", 9, "Cluj");
        Person p3 = new Person("Xr", "xi", 9, "Hamburg");
        Person p4 = new Person("Xhs", "lb", 19, "Cluj");
        exList.add(p1);
        exList.add(p2);
        exList.add(p3);
        exList.add(p4);
        //when
        List result = PersonService.sortPeopleByLastName(exList);
        //then
        assertTrue(result.get(1).equals(p4));
    }

    @Test
    void sortPeopleByFirstNameLastNameAge() {
        //given
        List<Person> exList = new ArrayList<>();
        Person p1 = new Person("Xr", "xl", 14, "Oradea");
        Person p2 = new Person("Xr", "xi", 9, "Cluj");
        Person p3 = new Person("Xr", "xi", 12, "Hamburg");
        Person p4 = new Person("Xr", "lb", 19, "Cluj");
        exList.add(p1);
        exList.add(p2);
        exList.add(p3);
        exList.add(p4);
        //when
        List result = PersonService.sortPeopleByFirstNameLastNameAge(exList);
        //then
        assertTrue(result.get(2).equals(p3));
    }
}