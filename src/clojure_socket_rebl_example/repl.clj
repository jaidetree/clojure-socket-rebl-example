(ns clojure-socket-rebl-example.repl
  (:require [cognitect.rebl]
            [clojure.main :as m]))

(defn repl-init
  "Initialize repl in user namespace and make standard repl requires."
  []
  (in-ns 'user)
  (apply require m/repl-requires))

(defn repl-eval
 "Enhanced :eval hook for repl supporting rebl/submit."
  [input]
  (let [output (eval input)]
    (cognitect.rebl/submit input output)
    output))

(defn repl-read
  "Enhanced :read hook for repl supporting :repl/quit."
  [request-prompt request-exit]
  (or ({:line-start request-prompt :stream-end request-exit}
       (m/skip-whitespace *in*))
      (let [input (read {:read-cond :allow} *in*)]
        (m/skip-if-eol *in*)
        (case input
          :repl/quit request-exit
          input))))

(defn repl
  "REPL with predefined hooks for attachable socket server."
  []
  (m/repl
    :init repl-init
    :read repl-read
    :eval repl-eval))
