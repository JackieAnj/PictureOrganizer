package tag;

import java.util.ArrayList;

public class Tag {

  private ArrayList<Image> taggedImages;
  private char hashTag = '@';
  private String name;

  public Tag(String name) {
    this.name = name;
    this.taggedImages = new ArrayList<>();
  }

  /**
   * Getters
   */
  public String getName() {
    return this.name;
  }

  public char getHashTag() {
    return this.hashTag;
  }

  public String getTag() {
    return this.hashTag + this.name;
  }

  public ArrayList<Image> getTaggedImages() {
    return this.taggedImages;
  }

  /**
   * Adds an image to the end of the ArrayList
   *
   * @param newImage The image to be added to the ArrayList
   */
  public void addImage(Image newImage) {
    //add newImage to taggedImages
    if(!taggedImages.contains(newImage)) {
      taggedImages.add(newImage);
    }
  }

  /**
   * Searches through taggedImages to find 'oldImage'
   * Removes it upon finding it
   *
   * @param oldImage The image to be removed
   */
  public void removeImage(Image oldImage) {
    //remove oldImage from taggedImages
    taggedImages.remove(oldImage);
  }
}
