package com.jinjection.easy.books;

import com.jinjection.easy.books.Author;
import com.jinjection.easy.books.Book;
import org.jinjection.ann.ConditionToExecute;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;

/**
 *
 * @author sommovir
 */
//@Disabled
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
@ConditionToExecute(classToCheck = Book.class)
public class BookTest {

    private String message;
    private String result;
    private static int vote = 0;

    public BookTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
//        ExecutingTest exeTest = Book.class.getDeclaredAnnotation(ExecutingTest.class);
//        if(!exeTest.enabled()){
//            System.exit(0);
//        }
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
//        ExecutingTest exeTest = Book.class.getDeclaredAnnotation(ExecutingTest.class);
//        if(!exeTest.enabled()){
//            System.exit(0);
//        }
        System.out.println("\n\n===========================================================");
        if (vote > 30) {
            System.out.println("\t\t\tYOUR VOTE: 30 e Lode !");
        } else {
            System.out.println("\t\t\tYOUR VOTE: " + vote + "/30");
        }

        System.out.println("===========================================================\n\n");
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
        System.out.println("[Test Module][Lesson2]" + message + ": " + result);
    }

    @Test
    @DisplayName("[Test incapsulamento](1/4) Easy: 2A.1 constructor with arguments and getter [book page]")
    public void test1(TestInfo info) {
        Author author = new Author("George", "Orwell");
        Book book = new Book("1984", 312, author);
        message = info.getDisplayName();
        result = "\t\t[FAIL]";
        assertEquals(312, book.getPages(), "Probabile problema di passaggio di parametri [pages] nel costruttore");
        result = "\t\t[SUCCESS]";
        vote += 1;

    }

    @Test
    @DisplayName("[Test incapsulamento](2/4) Easy: 2A.1 constructor with arguments and getter [book title]")
    public void test2(TestInfo info) {
        message = info.getDisplayName();
        result = "\t[FAIL]";
        Author author = new Author("George", "Orwell");
        Book book = new Book("1984", 312, author);
        assertEquals("1984", book.getTitle(), "Probabile problema di passaggio di parametri [title] nel costruttore");
        result = "\t[SUCCESS]";
        vote += 1;
    }

    @Test
    @DisplayName("[Test incapsulamento](3/4) Easy: 2A.1 constructor with arguments and getter [author name]")
    public void test3(TestInfo info) {
        message = info.getDisplayName();
        result = "\t[FAIL]";
        Author author = new Author("George", "Orwell");
        Book book = new Book("1984", 312, author);
        assertEquals("George", book.getAuthor().getName(), "Probabile problema di passaggio di parametri [author name] nel costruttore");
        result = "\t[SUCCESS]";
        vote += 1;
    }

    @Test
    @DisplayName("[Test incapsulamento](4/4) Easy: 2A.1 constructor with arguments and getter [author sur.]")
    public void test4(TestInfo info) {
        message = info.getDisplayName();
        result = "\t[FAIL]";
        Author author = new Author("George", "Orwell");
        Book book = new Book("1984", 312, author);
        assertEquals("Orwell", book.getAuthor().getSurname(), "Probabile problema di passaggio di parametri [author surname] nel costruttore");
        result = "\t[SUCCESS]";
        vote += 1;
    }

    @Test
    @DisplayName("[Test incapsulamento](1/4) Easy: 2A.1 constructor with arguments and setter [author name]")
    public void test5(TestInfo info) {
        message = info.getDisplayName();
        result = "\t[FAIL]";
        Author author = new Author("George", "Orwell");
        author.setName("Osvaldo");
        Book book = new Book("1984", 312, author);
        assertEquals("Osvaldo", book.getAuthor().getName(), "Probabile problema i getter/setter nella classe Author ");
        result = "\t[SUCCESS]";
        vote += 1;
    }

    @Test
    @DisplayName("[Test incapsulamento](2/4) Easy: 2A.1 constructor with arguments and setter [author title]")
    public void test6(TestInfo info) {
        message = info.getDisplayName();
        result = "\t[FAIL]";
        Author author = new Author("George", "Orwell");
        Book book = new Book("1984", 312, author);
        book.setTitle("Il signore delle mosche");
        assertEquals("Il signore delle mosche", book.getTitle(), "Probabile problema i getter/setter nella classe Book (title) ");
        result = "\t[SUCCESS]";
        vote += 1;
    }

    @Test
    @DisplayName("[Test incapsulamento](3/4) Easy: 2A.1 constructor with arguments and setter [book pages]")
    public void test7(TestInfo info) {
        message = info.getDisplayName();
        result = "\t[FAIL]";
        Author author = new Author("George", "Orwell");
        Book book = new Book("1984", 312, author);
        book.setPages(100);
        assertEquals(100, book.getPages(), "Probabile problema i getter/setter nella classe Book (pages) ");
        result = "\t[SUCCESS]";
        vote += 1;
    }

    @Test
    @DisplayName("[Test incapsulamento](4/4) Easy: 2A.1 constructor with arguments and setter [author]")
    public void test8(TestInfo info) {
        message = info.getDisplayName();
        result = "\t\t[FAIL]";
        Author author = new Author("George", "Orwell");
        Book book = new Book("1984", 312, author);
        Author author2 = new Author("Mario", "Rossi");
        book.setAuthor(author2);
        assertEquals(book.getAuthor().getName(), "Mario", "Probabile problema i getter/setter nella classi Book/Author");

        result = "\t\t[SUCCESS]";
        vote += 1;
    }

    @Test
    @DisplayName("[Test incapsulamento](1/4) Medium: 2A.2 invalid value management in constructor [negative]")
    public void test9(TestInfo info) {
        message = info.getDisplayName();
        result = "\t[FAIL]";
        Author author = new Author("George", "Orwell");
        Book book = new Book("1984", -312, author);
        assertEquals(book.getPages(), -1, "Non è stato gestito l'inserimento di numeri negativi come pagine nel costruttore");

        result = "\t[SUCCESS]";
        vote += 2;
    }

    @Test
    @DisplayName("[Test incapsulamento](2/4) Medium: 2A.2 invalid value management in constructor [zero]")
    public void test91(TestInfo info) {
        message = info.getDisplayName();
        result = "\t\t[FAIL]";
        Author author = new Author("George", "Orwell");
        Book book = new Book("1984", 0, author);
        assertEquals(book.getPages(), -1, "Non è stato gestito l'inserimento di numeri di pagine pari a zero nel costruttore");

        result = "\t\t[SUCCESS]";
        vote += 2;
    }

    @Test
    @DisplayName("[Test incapsulamento](3/4) Medium: 2A.2 invalid value management in setter [negative]")
    public void test92(TestInfo info) {
        message = info.getDisplayName();
        result = "\t\t[FAIL]";
        Author author = new Author("George", "Orwell");
        Book book = new Book("1984", 22, author);
        book.setPages(-28273);
        assertEquals(book.getPages(), -1, "Non è stato gestito l'inserimento di numeri di pagine negativo nel setter");

        result = "\t\t[SUCCESS]";
        vote += 2;
    }

    @Test
    @DisplayName("[Test incapsulamento](4/4) Medium: 2A.2 invalid value management in setter [zero]")
    public void test93(TestInfo info) {
        message = info.getDisplayName();
        result = "\t\t[FAIL]";
        Author author = new Author("George", "Orwell");
        Book book = new Book("1984", 22, author);
        book.setPages(0);
        assertEquals(book.getPages(), -1, "Non è stato gestito l'inserimento di numeri di pagine pari a zero nel setter");

        result = "\t\t[SUCCESS]";
        vote += 2;
    }

    @Test
    @DisplayName("[Test incapsulamento](1/6) Medium: 2A.3 invalid auth. value management in book constr. [empty]")
    public void test94(TestInfo info) {
        message = info.getDisplayName();
        result = "\t[FAIL]";
        Author author = new Author("", "");
        Book book = new Book("1984", 22, author);
        book.setPages(0);
        assertEquals("Autore", book.getAuthor().getName(), "Non è stato gestito l'inserimento di un autore via costruttore con nome vuoto");
        assertEquals("Sconosciuto", book.getAuthor().getSurname(), "Non è stato gestito l'inserimento di un autore via costruttore con cognome vuoto");
        result = "\t[SUCCESS]";
        vote += 2;
    }

    @Test
    @DisplayName("[Test incapsulamento](2/6) Medium: 2A.3 invalid auth. value management in book constr. [null]")
    public void test95(TestInfo info) {
        message = info.getDisplayName();
        result = "\t[FAIL]";
        Author author = new Author(null, null);
        Book book = new Book("1984", 22, author);
        book.setPages(0);
        assertEquals("Autore", book.getAuthor().getName(), "Non è stato gestito l'inserimento via costruttore di un autore con nome  nullo");
        assertEquals("Sconosciuto", book.getAuthor().getSurname(), "Non è stato gestito l'inserimento di un autore via costruttore con cognome nullo");
        result = "\t[SUCCESS]";
        vote += 2;
    }

    @Test
    @DisplayName("[Test incapsulamento](3/6) Medium: 2A.3 invalid value management with author [null]")
    public void test96(TestInfo info) {
        message = info.getDisplayName();
        result = "\t\t[FAIL]";
        Book book = new Book("1984", 22, null);
        book.setPages(0);
        assertEquals("Autore", book.getAuthor().getName(), "Non è stato gestito l'inserimento di un autore nullo");
        assertEquals("Sconosciuto", book.getAuthor().getSurname(), "Non è stato gestito l'inserimento di un autore nullo");
        result = "\t\t[SUCCESS]";
        vote += 2;
    }

    @Test
    @DisplayName("[Test incapsulamento](4/6) Medium: 2A.3 invalid value management in setting auth [null attr]")
    public void test97(TestInfo info) {
        message = info.getDisplayName();
        result = "\t[FAIL]";
        Author author = new Author("A", "B");
        Book book = new Book("1984", 22, author);
        book.setPages(0);
        Author fake = new Author(null, null);
        book.setAuthor(fake);
        assertEquals("Autore", book.getAuthor().getName(), "Non è stato gestito il settaggio di un autore con attributi nulli [name]");
        assertEquals("Sconosciuto", book.getAuthor().getSurname(), "Non è stato gestito il settaggio di un autore con attributi nulli [surname]");
        result = "\t[SUCCESS]";
        vote += 2;
    }

    @Test
    @DisplayName("[Test incapsulamento](5/6) Medium: 2A.3 invalid value management in setting auth [empty attr]")
    public void test98(TestInfo info) {
        message = info.getDisplayName();
        result = "\t[FAIL]";
        Author author = new Author("A", "B");
        Book book = new Book("1984", 22, author);
        book.setPages(0);
        Author fake = new Author("", "");
        book.setAuthor(fake);
        assertEquals("Autore", book.getAuthor().getName(), "Non è stato gestito il settaggio di un autore con attributi vuoti [name]");
        assertEquals("Sconosciuto", book.getAuthor().getSurname(), "Non è stato gestito il settaggio di un autore con attributi vuoti [surname]");
        result = "\t[SUCCESS]";
        vote += 2;
    }

    @Test
    @DisplayName("[Test incapsulamento](6/6) Medium: 2A.3 invalid value management in setting auth [null]")
    public void test99(TestInfo info) {
        message = info.getDisplayName();
        result = "\t\t[FAIL]";
        Author author = new Author("A", "B");
        Book book = new Book("1984", 22, author);
        book.setPages(22);
        book.setAuthor(null);
        assertEquals("Autore", book.getAuthor().getName(), "Non è stato gestito il settaggio di un autore nullo");
        assertEquals("Sconosciuto", book.getAuthor().getSurname(), "Non è stato gestito il settaggio di un autore nullo");
        result = "\t\t[SUCCESS]";
        vote += 2;
    }

    @Test
    @DisplayName("[Test incapsulamento](EXTRA) Medium: 2A.3 getting author attr. after using only empty constr.")
    public void test991(TestInfo info) {
        message = info.getDisplayName();
        result = "\t[FAIL]";
        Book book = new Book();
        book.setPages(22);
        assertEquals("Autore", book.getAuthor().getName(), "Non è stato gestito il settaggio di un autore nullo");
        assertEquals("Sconosciuto", book.getAuthor().getSurname(), "Non è stato gestito il settaggio di un autore nullo");
        result = "\t[SUCCESS]";
        vote += 1;
    }


    @Test
    @DisplayName("[Test incapsulamento](EXTRA) Hard: 2A.3 trying to hack author by setter")
    public void test992(TestInfo info) {
        message = info.getDisplayName();
        result = "\t\t\t\t[FAIL]";
        Author author = new Author("Federico", "Tiberi");
        Book book = new Book("Promessi Sposi", 234, author);
        author.setSurname("Cepilli");
        author.setName("Alessio");
        assertEquals("Federico", book.getAuthor().getName(), "Non è stato gestito l'eventuale hack esterno by setter");
        assertEquals("Tiberi", book.getAuthor().getSurname(), "Non è stato gestito l'eventuale hack esterno by setter");
        result = "\t\t\t\t[SUCCESS]";
        vote += 1;
    }

    @Test
    @DisplayName("[Test incapsulamento](EXTRA) Hard: 2A.3 trying to hack author by getter")
    public void test993(TestInfo info) {
        message = info.getDisplayName();
        result = "\t\t\t\t[FAIL]";
        Author author = new Author("Federico", "Tiberi");
        Book book = new Book("Promessi Sposi", 234, author);
        Author a2 = book.getAuthor();
        a2.setSurname("Cepilli");
        a2.setName("Alessio");
        assertEquals("Federico", book.getAuthor().getName(), "Non è stato gestito l'eventuale hack esterno by getter");
        assertEquals("Tiberi", book.getAuthor().getSurname(), "Non è stato gestito l'eventuale hack esterno by getter");
        result = "\t\t\t\t[SUCCESS]";
        vote += 1;
    }

}
