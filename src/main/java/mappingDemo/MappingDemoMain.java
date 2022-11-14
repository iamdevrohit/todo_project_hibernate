package mappingDemo;

import mappingDemo.repository.MappingRepo;

public class MappingDemoMain {

    public static void main(String[] args) {

     //  new MappingRepo().saveOnetoOne();
     //  new MappingRepo().saveOnetoMany();
       new MappingRepo().saveManytoMany();

    }
}
