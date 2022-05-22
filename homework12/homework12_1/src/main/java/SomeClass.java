@ThisCodeSmells(reviewer = "Reviewer1")
public class SomeClass {

    @ThisCodeSmells(reviewer = "Reviewer1")
    private String field1;

    @ThisCodeSmells(reviewer = "Reviewer2")
    private String field2;

    @ThisCodeSmells(reviewer = "Reviewer3")
    private String field3;

    @ThisCodeSmells(reviewer = "Reviewer1")
    public String getField1() {
        return field1;
    }

    @ThisCodeSmells(reviewer = "Reviewer1")
    public String getField2() {
        return field1;
    }

    @ThisCodeSmells(reviewer = "Reviewer2")
    public String getField3() {
        return field2;
    }

    @ThisCodeSmells(reviewer = "Reviewer3")
    public String getField4() {
        return field3;
    }
}
