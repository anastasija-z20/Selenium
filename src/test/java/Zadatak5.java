import org.testng.annotations.*;

public class Zadatak5 {
// Zadatak 5
// Napisati jednom na pocetku "Dobrodosli na kurs"
// Napisati pre svakog testa "Ucim za test"
// Napisati tri test metode - u prvoj odstampati "SQL"
// u drugom odstampati "Java"
// u trecem odstampati "Selenium"
// Nakon svakog testa ispisati "Polozen test"
// Na kraju ispisati "Polozen kurs"
    @BeforeClass
    public void pocetak(){
        System.out.println("Dobrodosli na kurs");
    }
    @BeforeMethod
    public void preTesta(){
        System.out.println("Ucim za test");
    }
    @Test(priority = 1)
    public void sql(){
        System.out.println("SQL");
    }
    @Test(priority = 2)
    public void java(){
        System.out.println("Java");
    }
    @Test(priority = 3)
    public void selenium(){
        System.out.println("Selenium");
    }
    @AfterMethod
    public void polozeno(){
        System.out.println("Polozen test");
    }
    @AfterClass
    public void kraj(){
        System.out.println("Polozen kurs");
    }
}
