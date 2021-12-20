package Records;

public class Groups {

    private int deptId;
    private String groupId;

    public Groups(int deptId, String groupId) {
        this.deptId = deptId;
        this.groupId = groupId;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}
