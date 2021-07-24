import java.io.Serializable;
import java.util.Objects;

public class Song implements Serializable {
    String id;
    String songName;
    String artistName;
    String albumName;

    public Song() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }


    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSongName(), getArtistName(), getAlbumName());
    }

    @Override
    public String toString() {
        return "Song{" +
                "id='" + id + '\'' +
                ", songName='" + songName + '\'' +
                ", artistName='" + artistName + '\'' +
                ", albumName='" + albumName + '\'' +
                '}';
    }
}
