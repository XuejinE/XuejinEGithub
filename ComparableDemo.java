//同时实现comparable，表示自己具备比较能力
class Teacher2 implements Comparable<Teacher2>{
    String name;
    int age;
    int height;
    int weight;

    public Teacher2(String name, int age, int height, int weight) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    //natural ordering
    //大小关系如何确定，留给开发者自己决定
    //目前的实现，是按照年龄进行比较
    @Override
    public int compareTo(Teacher2 o) {
          if(this.age<o.age){
              //this指向的对象“小于”o指向的对象
              return -1;//任意负数都可以
          }else if(this.age==o.age){
              //this指向的对象“等于”o指向的对象
              return 0;//任意整数都可以
          }else{
              //this指向的对象“大于”o指向的对象
              return 1;//任意整数都可以
          }
    }
}


public class ComparableDemo {
}
