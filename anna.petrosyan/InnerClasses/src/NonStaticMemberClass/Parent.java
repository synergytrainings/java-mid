package NonStaticMemberClass;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Emil on 15.05.2015.
 */
public class Parent {
    private String firstName;
    private String lastName;
    public Parent(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        children=new ArrayList();
    }
    List children;
    public List getChildren() {
        return children;
    }

    public void setChildren(List children) {
        this.children = children;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public  class Child {
        private String childName;
        private int childAge;
        private Parent childParent;

        public String getChildName() {
            return childName;
        }

        public void setChildName(String childName) {
            this.childName = childName;
        }

        public int getChildAge() {
            return childAge;
        }

        public void setChildAge(int childAge) {
            this.childAge = childAge;
        }

        public Parent getChildParent() {
            return childParent;
        }

        public void setChildParent(Parent childParent) {
            this.childParent = childParent;
        }

        public Child(String childName, int childAge) {
            this.childName = childName;
            this.childAge = childAge;
            this.childParent=Parent.this;
        }
    }

    public static void main(String[] args) {
        Parent p=new Parent("Anna","Petrosyan");
        p.children.add(p.new Child("Alex",1));
        System.out.println(((Child)p.children.get(0)).getChildParent().getFirstName());

    }
}
