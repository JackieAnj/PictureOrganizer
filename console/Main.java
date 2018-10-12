package console;

import tag.*;

import java.util.ArrayList;

public class Main {

  private Image selectedImage;
  private String selectedFileName;
  private Tag selectedTag;
  private ImageManager imageManager;
  private TagManager tagManager;
  private String directory;
  private TagManager tagmanager;

  public Main() {
    this.imageManager = new ImageManager();
    this.tagManager = new TagManager();
    //read(this.manager);
  }

  private void read(ImageManager imageManager) {
    //initialize program and read config files to fill Managers
  }

  public void selectImage(String fileName) {
    //change selectedFileName, and selectedImage if possible
  }

  public void selectTag(Tag tag) {
    //change selectedTag
  }

  public void updateLog() {
    //update log
  }

  public ArrayList<Tag> getAllTags() {
<<<<<<< HEAD
      // return list of all the tags
      // calls on the getTags method in TagManager class
    return this.tagmanager.getTags();
  }

  public ArrayList<Tag> getCurrentTags() {
      //return list of all tags in this.selectedImage
      return this.selectedImage.getCurrentTags();
  }

  public ArrayList<ArrayList<Tag>> getPreviousTags() {
      //return list of all previous tags in this.selectedImage
      return this.selectedImage.getPreviousTags();
=======
    // return list of all the tags
    return null;
  }

  public ArrayList<Tag> getCurrentTags() {
    //return list of all tags in this.selectedImage
    return null;
  }

  public ArrayList<ArrayList<Tag>> getPreviousTags() {
    //return list of all previous tags in this.selectedImage
    return null;
>>>>>>> 4273b6d17c6049807618740a65b8f5a7386e289d
  }

  public void renameFile(String newName) {
    //rename this.selectedFileName to newName, adjust this.selectedImage accordingly, refresh directory box
    //rename the file, make appropriate changes to selectedImage, selectedFileName, and actual file name
    //update log
    //update config files
  }

  public void moveFile(String newDirectory) {
    //move this.selectedFileName to newDirectory, adjust this.selectedImage accordingly, refresh directory box
    //rename the file, make appropriate changes to selectedImage, selectedFileName, and actual file name
    //update log
    //update config files
  }

  public void openDirectory() {
    //open direct directory of selectedFileName in window
  }

  public void addTag() {
<<<<<<< HEAD
      //add selectedTag to selectedImage; if selectedImage is null then make one with selectedFileName
      //if Tag is already in selectedImage then don't add it
      //refresh current tags and previous tags box
      //rename the file, make appropriate changes to selectedImage, selectedFileName, and actual file name
      //update log
      //update config files
      this.selectedImage.addCurrentTag(selectedTag);
  }

  public void addTag(String tagName) {
      //add new Tag with tagName to selectedImage; if tag already exists then find that tag object and add selectedImage to it
      //if selectedImage is null then make one with selectedFileName
      //refresh current tags and previous tags box
      //rename the file, make appropriate changes to selectedImage, selectedFileName, and actual file name
      //update log
      //update config files
      Tag newTag = new Tag(tagName);
      this.selectedImage.addCurrentTag(newTag);
  }

  public void removeTag() {
      //remove selectedTag from selectedImage if possible
      //refresh current tags and previous tags box
      //rename the file, make appropriate changes to selectedImage, selectedFileName, and actual file name
      //update log
      //update config files
      this.selectedImage.removeCurrentTag(selectedTag);
=======
    //add selectedTag to selectedImage; if selectedImage is null then make one with selectedFileName
    //if Tag is already in selectedImage then don't add it
    //refresh current tags and previous tags box
    //rename the file, make appropriate changes to selectedImage, selectedFileName, and actual file name
    //update log
    //update config files
  }

  public void addTag(String tagName) {
    //add new Tag with tagName to selectedImage and add Tag to TagManager's currentTags
    //if tag already exists then find that tag object and add selectedImage to it
    //if tag was found in previousTags then add that Tag back to currentTags
    //if selectedImage is null then make one with selectedFileName
    //refresh current tags and previous tags box
    //rename the file, make appropriate changes to selectedImage, selectedFileName, and actual file name
    //update log
    //update config files
  }

  public void removeTag() {
    //remove selectedTag from selectedImage if possible (i.e. selectedImage is not null and it has selectedTag)
    //if Tag now has no Images attached, remove Tag from TagManager's currentTags and add to previousTags
    //refresh current tags and previous tags box
    //rename the file, make appropriate changes to selectedImage, selectedFileName, and actual file name
    //update log
    //update config files
  }

  public void removeTag(String tagName) {
    //remove selectedTag from selectedImage if possible (i.e. selectedImage is not null and it has selectedTag)
    //if Tag now has no Images attached, remove Tag from TagManager's currentTags and add to previousTags
    //refresh current tags and previous tags box
    //rename the file, make appropriate changes to selectedImage, selectedFileName, and actual file name
    //update log
    //update config files
>>>>>>> 4273b6d17c6049807618740a65b8f5a7386e289d
  }

  public void revertTags(ArrayList<Tag> newTags) {
    //revert selectedImage's tags to newTags
    //refresh current tags and previous tags box
    //rename the file, make appropriate changes to selectedImage, selectedFileName, and actual file name
    //update log
    //update config files
  }

  //ALL METHODS BELOW ARE FOR CONSOLE APPLICATIONS OF PROGRAM (NOT GUI)
  private String input() {
    //Gets user input and returns it.
    return null;
  }

  private void setDirectory() {
    //set directory with input
  }

  private void displayDirectFiles() {
    //display direct image files in directory
  }

  private void displayAllFiles() {
    //display all image files in directory using displayDirectFiles and recursion on all subfolders
  }

  public static void main(String[] args) {
    Main program = new Main();

    System.out.println("Welcome to console version of program. Please enter directory.");
    program.setDirectory();
    System.out.println("These are all the image files under that directory:");
    program.displayAllFiles();
    String x = "";
    while (!x.equals("q")) {
      System.out.println("Select an image.");
      program.selectImage(program.input());
      if (program.selectedImage == null) {
        System.out.println("There are no tags for this image.");
      } else {
        System.out.println("These are the tags for this image.");
        for (Tag t : program.getCurrentTags()) {
          System.out.println(t.getName());
        }
        System.out.println("These were the previous tags for this image.");
        for (ArrayList<Tag> i : program.getPreviousTags()) {
          String temp = "";
          for (Tag j : i) {
            temp += j.getName() + ",";
          }
          System.out.println(temp.substring(0, temp.length() - 1));
        }
      }
      System.out.println("Select an action to do.");
      x = program.input();
      if (x.equals("add")) {
        program.addTag(program.input());
      } else if (x.equals("remove")) {
        program.removeTag(program.input());
      } else if (x.equals("rename")) {
        program.renameFile(program.input());
      } else if (x.equals("move")) {
        program.moveFile(program.input());
      } else if (x.equals("open")) {
        program.openDirectory();
      } else if (x.equals("revert")) {
        ArrayList<Tag> temp = new ArrayList<>();
        for (String s : program.input().split(",")) {
          Tag toAdd = program.tagManager.findCurrentTag(s);
          if (toAdd == null) {
            toAdd = program.tagManager.findPreviousTag(s);
          }
          temp.add(toAdd);
        }
        program.revertTags(temp);
      } else if (x.equals("change")) {
        program.setDirectory();
      }
    }

  }
}