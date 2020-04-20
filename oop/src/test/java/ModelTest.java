import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ModelTest {

    private static List<Mark> correctMarks;
    private static List<String> correctNotifications;
    private static Teacher teacher;
    private static Classroom classroom;
    private static Pupil pupil;
    private static Parent parent;
    private static Mark historyMark;
    private static Mark geographyMark;
    private static Mark englishMark;
    private static Mark mathematicsMark;

    @BeforeClass
    public static void initialize() {
        classroom = new Classroom(Short.parseShort("1"), "A");
        teacher = new Teacher("Ann", LocalDate.now(), User.Role.TEACHER, classroom);
        pupil = teacher.createPupil("Mike", LocalDate.now(), User.Role.PUPIL);
        parent = teacher.createParent("Jack", LocalDate.now(), User.Role.PARENT, pupil);
        historyMark = new Mark(teacher, new Subject("History"), Short.parseShort("8"));
        geographyMark = new Mark(teacher, new Subject("Geography"), Short.parseShort("7"));
        englishMark = new Mark(teacher, new Subject("English"), Short.parseShort("10"));
        mathematicsMark = new Mark(teacher, new Subject("Mathematics"), Short.parseShort("8"));

        correctMarks = new ArrayList<>();
        correctMarks.add(geographyMark);
        correctMarks.add(englishMark);
        correctMarks.add(historyMark);

        correctNotifications = new ArrayList<>();
        correctNotifications.add("Message for Jack | New mark from Mike: Date(2020-04-20), " +
                "Subject(Geography), Mark(7), Teacher(Ann)");
    }

//    @Test
//    public void administratorDeleteUser() {
//        Administrator administrator = new Administrator("Admin", LocalDate.now(), User.Role.ADMINISTRATOR);
//        Teacher teacher = new Teacher("Lily", LocalDate.now(), User.Role.TEACHER, classroom);
//        administrator.deleteUser(teacher);
//        System.gc();
//        Assert.assertNull(teacher);
//    }

    @Test
    public void createdPupilsAreLinkedWithHisParent() {
        Assert.assertEquals(pupil, parent.getPupils().get(0));
    }

    @Test
    public void createdPupilsAreLinkedWithHisClassroom() {
        Assert.assertEquals(pupil.getClassroom(), classroom);
    }

    @Test
    public void parentReviewPupilMarks() {
        teacher.addMark(pupil, geographyMark);
        teacher.addMark(pupil, englishMark);
        teacher.addMark(pupil, historyMark);
        teacher.addMark(new Pupil("", LocalDate.now(), User.Role.PUPIL, classroom), mathematicsMark);

        Assert.assertEquals(parent.getPupils().get(0).getMarks(), correctMarks);
    }

    @Test
    public void parentGetNotificationWhenHisPupilsGetMark() {
        teacher.addMark(pupil, geographyMark);
        Assert.assertEquals(parent.getNotifications(), correctNotifications);
    }

}