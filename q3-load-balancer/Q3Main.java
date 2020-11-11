import java.util.*;
import java.util.stream.Collectors;

public class Q3Main {

    private static List<Server> servers;
    private static List<Task> taskDefinitions;
    private static List<Task> taskQueue;

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        System.out.println("Input:");
        int lines = Integer.parseInt(sn.nextLine());

        servers = Arrays.stream(sn.nextLine().split("\\s"))
                .map(rumStr -> new Server(Integer.parseInt(rumStr)))
                .collect(Collectors.toList());
        taskDefinitions = new ArrayList<>();
        for(int i=1; i<=lines-2; i++) {
            String[] vals = sn.nextLine().trim().split("\\s");
            taskDefinitions.add(new Task(vals[0], Integer.parseInt(vals[1])) );
        }
        taskQueue = Arrays.stream(sn.nextLine().trim().split(""))
                .map(str -> new Task(str, getTaskRU(str)))
                .collect(Collectors.toList());

        while ( taskQueue.size()>0 ) {

            boolean noServerAvailable = true;
            for(Server server : servers) {
                if(server.canAddTask(taskQueue.get(0))) {
                    noServerAvailable = false;
                    server.addTask(taskQueue.get(0));
                    taskQueue.remove(0);
                }
            }

            if(noServerAvailable)
                break;
        }

        System.out.println("\nOutput:");
        for(Server server: servers)
            System.out.println(getTaskString(server.getTaskList()));
        System.out.println(getTaskString(taskQueue));
    }

    private static int getTaskRU(String name){
        return taskDefinitions.stream()
                .filter(task -> task.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No task with name ["+name+"]"))
                .getResourceUnits();
    }

    private static String getTaskString(List<Task> taskList) {
        return taskList.stream()
                .map(task -> task.getName())
                .collect(Collectors.joining());
    }
}