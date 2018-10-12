package tag;

import java.util.ArrayList;

public class TagManager {
<<<<<<< HEAD
    /**
     * class that keeps track of all the created tags as an ArrayList
     */
    private ArrayList<Tag> tags; // list of tags across all images
=======
    private ArrayList<Tag> currentTags; // list of tags across all images
    private ArrayList<Tag> previousTags;
>>>>>>> 4273b6d17c6049807618740a65b8f5a7386e289d

    public TagManager() {
        this.currentTags = new ArrayList<>();
        this.previousTags = new ArrayList<>();
    }

<<<<<<< HEAD
    /**
     * getter for a specific Tag
     * @param TagName name of the Tag that is being searched for
     * @return return the Tag object given the name if it exists, otherwise return null
     */
    public Tag getTag(String TagName) {
        for(Tag i : this.tags) {
            if (i.getName().equals(TagName))
                return i;
=======
    public Tag findCurrentTag(String tagName) {
        //return tag given tag name
        //if no such tag exist return null
        for (Tag t : this.currentTags) {
            if (t.getName().equals(tagName))
                return t;
        }
        return null;
    }

    public Tag findPreviousTag(String tagName) {
        for (Tag t : this.previousTags) {
            if (t.getName().equals(tagName))
                return t;
>>>>>>> 4273b6d17c6049807618740a65b8f5a7386e289d
        }
        return null;
    }

<<<<<<< HEAD
    /**
     * getter for all the created Tags
     * @return return the ArrayList containing all created Tags across all Images
     */
    public ArrayList<Tag> getTags() {
=======
    public ArrayList<Tag> getCurrentTags() {
>>>>>>> 4273b6d17c6049807618740a65b8f5a7386e289d
        //return ArrayList of all currently existing Tags
        return this.currentTags;
    }

    public void addTag(String tagName) {
        this.currentTags.add(new Tag(tagName));
    }

    public void removeTag(Tag tag) {
        this.currentTags.remove(tag);
        this.previousTags.add(tag);
    }

    public void readdTag(Tag tag) {
        this.currentTags.add(tag);
        this.previousTags.remove(tag);
    }
}
