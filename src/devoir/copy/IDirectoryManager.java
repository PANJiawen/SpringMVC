package devoir.copy;

import java.util.Collection;



public interface IDirectoryManager 
{
    // créer un utilisateur anonyme
    void newUser(long id,String password);

    // chercher une personne
    Person findPerson(long personId);

    // chercher un groupe
    //Group findGroup(User user, long groupId);
    Group findGroup(long groupId);

    // chercher les personnes d'un groupe
    Collection<Person> findAllPersons(long userid, long groupId);

    // identifier un utilisateur
    boolean login(long id, String password);
    
    boolean loginu(long id, String password);

    // oublier l'utilisateur
    void logout(User user);

    // enregistrer une personne
    void savePerson(Person p);
    
    // virifier l'existe de ID dans personss et user;
    boolean checkID(long id);
}
