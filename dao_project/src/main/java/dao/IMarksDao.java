package dao;

import entities.Discipline;
import entities.Marks;
import entities.User;

import java.util.List;

public interface IMarksDao {
    List<Marks> findAll();
    List<Marks> findAllNoDigits();
    List<Marks> findAllUserMarks(long userId);
    List<Marks> findAllDisciplineMarks(long disciplineId);
    List<Marks> findById(long id);
    List<Marks> findByIdNoDigits(long id);
    Marks save(Marks mark);
    Marks update(long id, Marks mark);
    void delete(long id);
}
