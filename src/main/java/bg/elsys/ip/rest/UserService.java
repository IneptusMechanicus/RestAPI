package bg.elsys.ip.rest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class UserService {
	private static UserService instance;

	public static UserService getInstance() {
		if (instance == null) {
			instance = new UserService();
		}
		return instance;
	}

	private List<Instrument> userList = new ArrayList<>();

	public UserService() {
		userList.add(new Instrument(1, "Guitar", "Fender", "Stratocaster", 201611));
		userList.add(new Instrument(2, "Keyboard", "Casio", "CK-2200", 201407));
		userList.add(new Instrument(3, "Drums", "Yamaha", "Whatever", 200211));

	}

	public List<Instrument> getInstr() {
		return Collections.unmodifiableList(userList);
	}

	public void addInstr(Instrument instr) {
		userList.add(instr);
	}
}
