package com.gmail.tsa;

public interface GroupDAO {
	public void saveGroup(Group group);

	public Group loadGroupByName(String groupName);
}
