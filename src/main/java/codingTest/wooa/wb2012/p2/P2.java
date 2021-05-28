package codingTest.wooa.wb2012.p2;

import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    private static class FileType {
        private final String name;
        private int totalSize;

        public FileType(String name) {
            this.name = name;
            totalSize = 0;
        }

        public void sumSize(int size) {
            totalSize += size;
        }

        public void initTotalSize() {
            totalSize = 0;
        }

        @Override
        public String toString() {
            return name + " " + totalSize + "b";
        }
    }

    private static class FileInfo {
        private final String name;
        private final String extension;
        private final int size;

        public FileInfo(String inputFileInfo) {
            String[] fileFullNameAndSize = inputFileInfo.split(" ");
            String fileFullName = fileFullNameAndSize[0];
            String size = fileFullNameAndSize[1];
            int extensionDelimiterIndex = fileFullName.lastIndexOf(".");

            name = fileFullName.substring(extensionDelimiterIndex);
            extension = fileFullName.substring(extensionDelimiterIndex + 1);
            this.size = Integer.parseInt(size.substring(0, size.length() - 1));
        }
    }

    private final Map<String, FileType> fileTypeByExtension = new HashMap<>();
    private final FileType music = new FileType("music");
    private final FileType images = new FileType("images");
    private final FileType movies = new FileType("movies");
    private final FileType other = new FileType("other");

    public String solution(String S) {
        initFileTypeByExtension();
        initFileTypeTotalSize();
        
        String[] fileInfos = S.split(System.lineSeparator());
        for (String inputFileInfo : fileInfos) {
            FileInfo fileInfo = new FileInfo(inputFileInfo);
            FileType fileType = getFileTypeBy(fileInfo.extension);
            fileType.sumSize(fileInfo.size);
        }

        return getTotalSizeInfo();
    }

    private void initFileTypeByExtension() {
        fileTypeByExtension.put("mp3", music);
        fileTypeByExtension.put("aac", music);
        fileTypeByExtension.put("flac", music);
        fileTypeByExtension.put("jpg", images);
        fileTypeByExtension.put("bmp", images);
        fileTypeByExtension.put("gif", images);
        fileTypeByExtension.put("mp4", movies);
        fileTypeByExtension.put("avi", movies);
        fileTypeByExtension.put("mkv", movies);
    }

    private void initFileTypeTotalSize() {
        music.initTotalSize();
        images.initTotalSize();
        movies.initTotalSize();
        other.initTotalSize();
    }

    private FileType getFileTypeBy(String extension) {
        FileType fileType = fileTypeByExtension.get(extension);

        if (fileType == null) {
            return other;
        }

        return fileType;
    }

    private String getTotalSizeInfo() {
        return music.toString() + System.lineSeparator()
                + images.toString() + System.lineSeparator()
                + movies.toString() + System.lineSeparator()
                + other.toString();
    }
}

public class P2 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.solution("my.song.mp3 11b\n" +
                "greatSong.flac 1000b\n" +
                "not3.txt 5b\n" +
                "video.mp4 200b\n" +
                "game.exe 100b\n" +
                "mov!e.mkv 10000b"))
                .isEqualTo("music 1011b\n" +
                        "images 0b\n" +
                        "movies 10200b\n" +
                        "other 105b");

        out.println("p2" + " success!");
    }
}
