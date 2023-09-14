package utils;

import constants.ConfigMap;
import constants.GlobalVars;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;

/**
 * RemoveOldReports removes all the reports older than X days. User can set the decision to delete
 * the files in properties file. <br/>
 * Class is final to avoid extend. <br/>
 * <br/>
 * Jun 7, 2022
 *
 * @version 1.0
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FileHandler {

  /**
   * This method deletes all the X days older reports and videos. <br/>
   * Jun 7, 2022
   */
  public static void deleteOldReports() {
    File targetDirForReport = new File(GlobalVars.getReportDir());
    File targetDirForVideos = new File(GlobalVars.getVideoDir());
    if (PropertyUtils.get(ConfigMap.DELETEOLDREPORTS).equals(GlobalVars.getYes())) {
      if (targetDirForReport.exists()) {
        deleteOldFiles(Objects.requireNonNull(targetDirForReport.listFiles()));
      }
      if (targetDirForVideos.exists()) {
        deleteOldFiles(Objects.requireNonNull(targetDirForVideos.listFiles()));
      }
    }
  }

  /**
   * This method deletes all the X days older reports and videos.<br/>
   * Jun 22, 2022
   *
   * @param filesToDelete Path for files to be deleted
   */
  private static void deleteOldFiles(File[] filesToDelete) {
    int daysBack = Integer.parseInt(PropertyUtils.get(ConfigMap.NUMBEROFDAYS));
    long purgeTime = System.currentTimeMillis() - ((long) daysBack * 24 * 60 * 60 * 1000);
    for (File report : filesToDelete) {
      assert report.lastModified() >= purgeTime || report.delete();
    }
  }

  /**
   * This function will clean old data from screenshots folder <br/>.
   * Jun 26, 2022
   *
   * @param path Directory path to be deleted
   */
  public static void deleteDir(String path) {
    try {
      if (new File(path).exists()) FileUtils.deleteDirectory(new File(path));
    } catch (IOException e) {
      ShellCmdUtils.throwException(e);
    }
  }

  public static void createDir(String path) {
    try {
      if (!new File(path).exists()) FileUtils.forceMkdir(new File(path));
    } catch (IOException e) {
      ShellCmdUtils.throwException(e);
    }
  }

  public static void copyFile(String from, String to) {
    try {
      if (new File(from).exists()) FileUtils.copyFile(new File(from), new File(to));
    } catch (IOException e) {
      ShellCmdUtils.throwException(e);
    }
  }

  public static String getLastModifiedFilePath(String directoryFilePath, String suffix) throws IOException {
    Path dir = Paths.get(directoryFilePath); // specify directory
    Optional<String> lastFilePath =
        Files.list(dir) // get the stream with full directory listing
            .filter(path -> path.toString().endsWith(suffix)) // exclude incorrect file type
            .max(
                Comparator.comparingLong(
                    f ->
                        f.toFile()
                            .lastModified())) // get the last file using comparator by lastModified
            // field
            .map(Object::toString); // convert to string

    return lastFilePath.orElse("No file found");
  }
}
