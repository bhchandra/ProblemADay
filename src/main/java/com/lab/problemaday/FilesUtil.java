package com.lab.problemaday;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static java.util.stream.Collectors.toList;

/**
 * @author MITRA
 */
public final class FilesUtil {

    private static List<File> filesMatching(Path dir, Predicate<File> matcher) {
        return Try.of(
                () -> Files.list(dir)
                        .map(Path::toFile)
                        .filter(matcher)
                        .collect(toList()))
                .applyOrElse(ArrayList::new);
    }

    public static List<File> filesEnding(Path dir, String regex) {
        return filesMatching(dir, f -> f.getName().endsWith(regex));
    }

    public static List<File> filesContaining(Path dir, String regex) {
        return filesMatching(dir, f -> f.getName().contains(regex));
    }

    public static List<File> filesMatching(Path dir, String regex) {
        return filesMatching(dir, f -> f.getName().matches(regex));
    }

    @FunctionalInterface
    public interface CheckedSupplier<T> {

        T get() throws IOException;
    }

    @FunctionalInterface
    public interface Try<T> {

        T apply();

        static <T> Try<T> of(CheckedSupplier<T> s) {
            return () -> {
                try {
                    return s.get();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            };
        }

        default T applyOrElse(Supplier<T> s) {
            try {
                return apply();
            } catch (Exception e) {
                return s.get();
            }
        }
    }

}
