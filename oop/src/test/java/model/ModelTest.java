package model;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModelTest {

    private static List<Mark> correctMarks;
    private static List<String> correctNotifications;
    private static Administrator administrator;
    private static Teacher teacher;
    private static Pupil pupil;
    private static Parent parent;
    private static Classroom classroom;
    private static Mark historyMark;
    private static Mark geographyMark;
    private static Mark englishMark;
    private static Mark mathematicsMark;


    @BeforeClass
    public static void initialize() {
        classroom = new Classroom(Short.parseShort("1"), "А");
        teacher = new Teacher("Ann", LocalDate.now(), User.Role.TEACHER, classroom);
        pupil = teacher.createPupil("Mike", LocalDate.now(), User.Role.PUPIL);
        parent = teacher.createParent("Jack", LocalDate.now(), User.Role.PARENT, pupil);
        historyMark = new Mark(teacher, new Subject("History"), Short.parseShort("8"));
        geographyMark = new Mark(teacher, new Subject("Geography"), Short.parseShort("7"));
        englishMark = new Mark(teacher, new Subject("English"), Short.parseShort("10"));
        mathematicsMark = new Mark(teacher, new Subject("Mathematics"), Short.parseShort("8"));
        administrator = new Administrator("Admin", LocalDate.now(), User.Role.ADMINISTRATOR);

        correctMarks = new ArrayList<>();
        correctMarks.add(geographyMark);
        correctMarks.add(englishMark);
        correctMarks.add(historyMark);

        correctNotifications = new ArrayList<>();
        correctNotifications.add("Message for Michael | New mark from Nick: Date(" + LocalDate.now()
                + "), Subject(Geography), Mark(7), Teacher(Ann)");
    }

//    @Test
//    public void administratorDeleteUser() {
//        model.Administrator administrator = new model.Administrator("Admin", LocalDate.now(), model.User.Role.ADMINISTRATOR);
//        model.Teacher teacher = new model.Teacher("Lily", LocalDate.now(), model.User.Role.TEACHER, classroom);
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
    public void parentGetNotificationWhenPupilsGetMark() {
        Pupil pupil = new Pupil("Nick", LocalDate.now(), User.Role.PUPIL, classroom);
        Parent parent = teacher.createParent("Michael", LocalDate.now(), User.Role.PARENT, pupil);
        teacher.addMark(pupil, geographyMark);
        Assert.assertEquals(parent.getNotifications(), correctNotifications);
    }

    @Test
    public void administratorCreateClassroom() {
        Classroom classroom = administrator.createClassroom(Short.parseShort("2"), "А");
        Assert.assertEquals(classroom.getClass(), Classroom.class);
    }

    @Test
    public void administratorCreateSubject() {
        Subject subject = administrator.createSubject("Subject");
        Assert.assertEquals(subject.getClass(), Subject.class);
    }

    @Test
    public void administratorCreateTeacher() {
        Teacher teacher = administrator.createTeacher("Teacher", LocalDate.now(), User.Role.TEACHER, classroom);
        Assert.assertEquals(teacher.getClass(), Teacher.class);
    }

    @Test
    public void administratorCreatePupil() {
        Pupil pupil = administrator.createPupil("Pupil", LocalDate.now(), User.Role.PUPIL, classroom);
        Assert.assertEquals(pupil.getClass(), Pupil.class);
    }

    @Test
    public void administratorCreateParent() {
        Parent parent = administrator.createParent("Parent", LocalDate.now(), User.Role.PARENT, pupil);
        Assert.assertEquals(parent.getClass(), Parent.class);
    }


    @Test
    public void teacherCreatePupil() {
        Pupil pupil = teacher.createPupil("Pupil", LocalDate.now(), User.Role.PUPIL);
        Assert.assertEquals(pupil.getClass(), Pupil.class);
    }

    @Test
    public void teacherCreateParent() {
        Parent parent = teacher.createParent("Parent", LocalDate.now(), User.Role.PARENT, pupil);
        Assert.assertEquals(parent.getClass(), Parent.class);
    }

    @Test
    public void teacherAddMark() {
        Pupil pupil = teacher.createPupil("Pupil", LocalDate.now(), User.Role.PUPIL);
        teacher.addMark(pupil, geographyMark);
        Assert.assertEquals(pupil.getMarks().get(0), geographyMark);
    }

    @Test
    public void teacherAddPupilToParent() {
        Pupil pupil = teacher.createPupil("Pupil", LocalDate.now(), User.Role.PUPIL);
        Pupil anotherPupil = teacher.createPupil("Another Pupil", LocalDate.now(), User.Role.PUPIL);
        Parent parent = teacher.createParent("Parent", LocalDate.now(), User.Role.PARENT, pupil);
        parent.addPupil(anotherPupil);
        Assert.assertEquals(parent.getPupils(), Arrays.asList(pupil, anotherPupil));
    }
}