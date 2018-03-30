package com.gmail.tsa;

import java.io.File;

public class ViewService implements Runnable {
	private File folderName;
	private File[] nowFileArray;
	private File[] nextStepFileArray;

	public ViewService(File folderName) {
		super();
		this.folderName = folderName;
		nowFileArray = folderName.listFiles();
	}

	public ViewService() {
		super();
		this.folderName = new File(".");
		nowFileArray = folderName.listFiles();
	}

	public File getFolderName() {
		return folderName;
	}

	public void setFolderName(File folderName) {
		this.folderName = folderName;
	}

	@Override
	public void run() {
		Thread th = Thread.currentThread();
		for (; !th.isInterrupted();) {
			try {
				nextStepFileArray = folderName.listFiles();
				String res = checkArrays(nowFileArray, nextStepFileArray);
				if (res.length() > 0) {
					System.out.println(res);
				}
				nowFileArray = nextStepFileArray;
				Thread.sleep(1000);

			} catch (InterruptedException e) {
				e.printStackTrace();
				break;
			}
		}
	}

	private String checkArrays(File[] now, File[] nextStep) {
		StringBuilder sb = new StringBuilder();
		for (File fileOne : now) {
			int ext = 0;
			for (File fileTwo : nextStep) {
				if (fileOne.getName().equals(fileTwo.getName())) {
					ext = 1;
					break;
				}
			}
			if (ext == 0) {
				sb.append(fileOne.getName() + " is Deleted").append(System.lineSeparator());
			}
		}
		for (File fileOne : nextStep) {
			int ext = 0;
			for (File fileTwo : now) {
				if (fileOne.getName().equals(fileTwo.getName())) {
					ext = 1;
				}
			}
			if (ext == 0) {
				sb.append(fileOne.getName() + " is Addet").append(System.lineSeparator());
			}
		}
		return sb.toString();
	}

}
