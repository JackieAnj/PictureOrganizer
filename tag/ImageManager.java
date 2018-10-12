package tag;

import java.util.ArrayList;

public class ImageManager {
    /**
     * class that keeps track of all image objects
     */
    private ArrayList<Image> images; // this may be changed to a tree implementation

    public ImageManager() {
        this.images = new ArrayList<>();
    }

    /**
     * getter for a specific Image
     * @param fileName name of Image that is being searched for
     * @return return the Image object given the name if it exists, otherwise return null
     */
    public Image getImage(String fileName) {
        for(Image i : this.images) {
            if (i.getFileName().equals(fileName)) {
                return i;
            }
        }
        return null;
    }

    /**
     * method for creating a new image and adding it to the ArrayList
     * @param fileName the name of the new image object
     */
    public void addImage(String fileName) {
        //create Image with fileName and add to images
        this.images.add(new Image(fileName));
    }

}
