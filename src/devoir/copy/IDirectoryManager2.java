package devoir.copy;

import java.util.Collection;



public interface IDirectoryManager2 
{
    // créer un utilisateur anonyme
    User newUser();

    // chercher une personne
    Person findPerson(User user, long personId);

    // chercher un groupe
    //Group findGroup(User user, long groupId);
    Group findGroup(int groupId);

    // chercher les personnes d'un groupe
    Collection<Person> findAllPersons(User user, long groupId);

    // identifier un utilisateur
    boolean login(User user, long personId, String password);

    // oublier l'utilisateur
    void logout(User user);

    // enregistrer une personne
    void savePerson(User user, Person p);
}
