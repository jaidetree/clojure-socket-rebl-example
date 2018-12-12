# Clojure Socket REPL with REBL Example

This source provides an example of how to setup Cognitect’s [REBL](https://github.com/cognitect-labs/REBL-distro) to work with a [Clojure Socket REPL server](https://clojure.org/reference/repl_and_main).

You could create a library from the source to simplify some of the setup but this should serve as a broader example of how the pieces fit together.

## Usage

1. Setup your deps.edn. It is best to follow the example from the official [REBL Usage](https://github.com/cognitect-labs/REBL-distro#usage). However, for your convenience:

    ```clojure
    {:deps {}
     :aliases
     {:rebl {:extra-deps
             {org.clojure/clojure {:mvn/version "1.10.0-RC2"}
              org.clojure/core.async {:mvn/version "0.4.490"}
              com.cognitect/rebl {:local/root "/Users/jay/Downloads/REBL-0.9.109/REBL-0.9.109.jar"}}}}}
    ```

2. Download the [REBL jar](http://rebl.cognitect.com/download.html) and update the path in deps.edn.
3. Run this command in your shell:

```shell
clj -J-Dclojure.server.repl="{:port 5555 :accept clojure-socket-rebl-example.repl/repl}" -R:rebl -m cognitect.rebl
```
