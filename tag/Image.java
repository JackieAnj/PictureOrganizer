package tag;

import java.util.ArrayList;

public class Image {

  private ArrayList<Tag> currentTags;
  private ArrayList<ArrayList<Tag>> previousTags;
  private String fileName;

  public Image(String fileName) {
    this.fileName = fileName;
    this.currentTags = new ArrayList<>();
    this.previousTags = new ArrayList<>();
  }

  /**
   * Getters/Setters
   */
  public String getFileName() {
    return this.fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public ArrayList<Tag> getCurrentTags() {
    return this.currentTags;
  }

  public ArrayList<ArrayList<Tag>> getPreviousTags() {
    return this.previousTags;
  }

  /**
   * 1) if tag is not in current, we can add it
   * 2) now we must also check if it exists in previousTags
   * 3) if the tag exists in previousTags, remove it
   *
   * @param newTag The tag to be added current and removed from previous
   */
  public void addCurrentTag(Tag newTag) {
    if (!currentTags.contains(newTag)) {
      //Makes sure there is only one instance of the Tag inside the ArrayList
      this.previousTags.add(this.currentTags);
      this.currentTags.add(newTag);
      newTag.addImage(this);
    }
  }

  /**
   * 1) checks if the tag is in current
   * 2) if tag is in current, we can add it to previous
   * 3) we then remove the tag from current
   *
   * @param oldTag The tag to check
   */
  public void removeCurrentTag(Tag oldTag) {
    if (currentTags.contains(oldTag)) {
      //Makes sure there is only one instance of the Tag inside the ArrayList
      this.previousTags.add(this.currentTags);
      this.currentTags.remove(oldTag);
      oldTag.removeImage(this);
    }
  }
}