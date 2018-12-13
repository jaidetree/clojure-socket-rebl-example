(ns clojure-socket-rebl-example.repl
  (:require [cognitect.rebl]
            [clojure.main :as m]
            [clojure.core.server :refer [repl-init repl-read]]))

(defn repl-eval
 "Enhanced :eval hook for repl supporting rebl/submit."
  [input]
  (let [output (eval input)]
    (cognitect.rebl/submit input output)
    output))

(defn repl
  "REPL with predefined hooks for attachable socket server."
  []
  (m/repl
    :init repl-init
    :read repl-read
    :eval repl-eval))
