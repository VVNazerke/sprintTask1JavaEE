package db;

import model.Tasks;

import java.util.ArrayList;
import java.util.Objects;

public class DBManager {

    public static ArrayList<Tasks> tasks = new ArrayList<>();
    public static Long id = 2L;

    static {
        tasks.add(new Tasks(1L,
                "Pass sprint task 1",
                "I must do and pass sprint task 1 in Java EE module!!",
                "2023-04-17"));
    }

    public static void addTask(Tasks task){  //этот метод добавляет новую задачу в список
        task.setId(id);
        tasks.add(task);
        id++;
    }

    public static Tasks getTask(Long id){ // этот метод возвращает объект задачи по id
        return tasks.stream().filter(task -> Objects.equals(id, task.getId())).findFirst().orElse(null);
    }

    public static ArrayList getAllTasks(){ //этот метод возвращает список всех задач
        return tasks;
    }

    public static void updateTask(Tasks zadacha){
        for (int i = 0; i< tasks.size();i++){
            if (Objects.equals(tasks.get(i).getId(), zadacha.getId())){
                tasks.set(i,zadacha);
                break;
            }
        }
    }

    public static void deleteTask(int id){ //этот метод удаляет задачу из списка по id
        tasks.remove(id);
    }

}
