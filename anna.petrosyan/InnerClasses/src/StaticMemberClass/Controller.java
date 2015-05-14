package StaticMemberClass;

/**
 * Created by Anna on 14.05.2015.
 */
public class Controller {
    private static class PersonDTO{
        private String passportNo;
        private Integer id;
        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public PersonDTO(String passportNo) {
            this.passportNo = passportNo;
        }

        public String getPassportNo() {
            return passportNo;
        }

        public void setPassportNo(String passportNo) {
            this.passportNo = passportNo;
        }


    }
    public void  getPersonToTransfer(Person p)
    {
//            ObjectMapper mapper = new ObjectMapper();
//            return mapper.writeValueAsString(getPersonDTOFromPerson(p));

    }

}
