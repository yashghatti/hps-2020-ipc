import java.util.Objects;
import java.util.UUID;

public class Task {

    private String name;
    private int resourceUnits;
    private String id;

    public Task(String name, int resourceUnits) {
        this.name = name;
        this.resourceUnits = resourceUnits;
        this.id = UUID.randomUUID().toString().substring(0,4);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResourceUnits() {
        return resourceUnits;
    }

    public void setResourceUnits(int resourceUnits) {
        this.resourceUnits = resourceUnits;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", resourceUnits=" + resourceUnits +
                ", id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id.equals(task.id);
    }

}
