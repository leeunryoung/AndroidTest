package j230616;

public class MemberDTO {
	 private String id;
	 private String pwd;
	 private String name;
	 private String age;
	 private String addr;
	 private String guruk;
	 private String gender;
	 private String specialty;
	 
	    public MemberDTO() {
	    }
	    public MemberDTO(String id, String Pwd, String name, String age,String addr, String guruk,String gender,String specialty) {
	        this.id = id;
	        this.pwd = Pwd;
	        this.name =name;
	        this.age=age;
	        this.addr=addr;
	        this.guruk=guruk;
	        this.gender=gender;
	        this.specialty=specialty;	        
	    }

		public String getId() {
			return id;
		}
		public void setId(String Id) {
			this.id = id;
		}
		public String getPwd() {
			return pwd;
		}
		public void setPwd(String Pwd) {
			this.pwd = pwd;
		}
	 /**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public String getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(String age) {
		this.age = age;
	}

	/**
	 * @return the addr
	 */
	public String getAddr() {
		return addr;
	}

	/**
	 * @param addr the addr to set
	 */
	public void setAddr(String addr) {
		this.addr = addr;
	}

	/**
	 * @return the guruk
	 */
	public String getGuruk() {
		return guruk;
	}

	/**
	 * @param guruk the guruk to set
	 */
	public void setGuruk(String guruk) {
		this.guruk = guruk;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the specialty
	 */
	public String getSpecialty() {
		return specialty;
	}

	/**
	 * @param specialty the specialty to set
	 */
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}


}
