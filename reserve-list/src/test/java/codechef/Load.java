package codechef;

/**
 * Created with IntelliJ IDEA.
 * User: u292148
 * Date: 2013.04.05.
 * Time: 9:49
 * To change this template use File | Settings | File Templates.
 */
public class Load {
    private Long id;

    private String name;

    public Load() {
    }

    public Load(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Load{" +
          "id=" + id +
          ", name='" + name + '\'' +
          '}';
    }
}
