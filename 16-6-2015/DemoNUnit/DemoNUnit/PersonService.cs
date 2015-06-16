using System;
using System.Collections.Generic;

public class Person
{
    public string Id;
    public string FirstName;
    public string LastName;

    public Person(string newId, string fn, string ln)
    {
        Id = newId;
        FirstName = fn;
        LastName = ln;
    }
}

public interface IPersonRepository
{
    List<Person> GetPeople();

    Person GetPersonById(string id);
}

public class PersonService
{
    private IPersonRepository personRepos;

    public PersonService(IPersonRepository repos)
    {
        personRepos = repos;
    }

    public List<Person> GetAllPeople()
    {
        return personRepos.GetPeople();
    }

    public List<Person> GetAllPeopleSorted()
    {
        List<Person> people = personRepos.GetPeople();
        people.Sort(delegate(Person lhp, Person rhp)
                        {
                            return lhp.LastName.CompareTo(rhp.LastName);
                        });

        return people;
    }

    public Person GetPerson(string id)
    {
        try
        {
            return personRepos.GetPersonById(id);
        }
        catch (ArgumentException)
        {
            return null; // no person with that id was found
        }
    }
}