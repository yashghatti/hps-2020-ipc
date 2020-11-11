import java.util.*;
import java.util.stream.Collectors;

public class Q3Main {

    private static List<Server> servers;
    private static List<Task> taskDefinitions;
    private static List<Task> taskQueue;
    private static int position = 0;

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        System.out.println("Input:");
        int lines = Integer.parseInt(sn.nextLine());

        servers = Arrays.stream(sn.nextLine().split("\\s"))
                .map(rumStr -> new Server(Integer.parseInt(rumStr), ++position))
                .collect(Collectors.toList());
        taskDefinitions = new ArrayList<>();
        for(int i=1; i<=lines-2; i++) {
            String[] vals = sn.nextLine().trim().split("\\s");
            taskDefinitions.add(new Task(vals[0], Integer.parseInt(vals[1])) );
        }
        taskQueue = Arrays.stream(sn.nextLine().trim().split(""))
                .map(str -> new Task(str, getTaskRU(str)))
                .collect(Collectors.toList());

        position = 1;
        while ( taskQueue.size()>0 ) {
            Server availableServer = getFirstAvailableServer(taskQueue.get(0));
            if(availableServer == null)
                break;
            else {
                availableServer.addTask(taskQueue.get(0));
                taskQueue.remove(0);
                position = getNextPosition(position);
            }
        }

        System.out.println("\nOutput:");
        for(Server server: servers)
            System.out.println(server.getTaskList()
                    .stream()
                    .map(task -> task.getName())
                    .collect(Collectors.joining()));
        System.out.println(taskQueue.stream()
                .map(task -> task.getName())
                .collect(Collectors.joining()));
    }

    private static int getTaskRU(String name){
        return taskDefinitions.stream()
                .filter(task -> task.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No task with name ["+name+"]"))
                .getResourceUnits();
    }

    private static Server getFirstAvailableServer(Task t) {
        Server availabeServer = null;
        for(int i=1, p=position; i<=servers.size(); i++) {
            final int p1 = p;
            Server server = servers.stream()
                    .filter(s -> s.getPosition() == p1)
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("No server with position ["+p1+"]"));
            if(server.canAddTask(t)) {
                availabeServer = server;
                break;
            }
            p = getNextPosition(p);
        }
        return availabeServer;
    }

    private static int getNextPosition(int position) {
        int newPos = ++position;
        if(newPos > servers.size())
            newPos = 1;
        return newPos;
    }
}