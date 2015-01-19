get-view "Package Explorer" | get-tree | select "sample/src/diagrams/newDiagram.diagram" | double-click
with [get-editor newDiagram] {
    get-diagram -index 1 | mouse-move 569 186 -height 447 -width 570
    with [get-palette] {
        get-palette-entry Stacked | mouse-move 2 18 -height 281 -width 130
        get-palette-entry Objects | mouse-move 44 44 -height 46 -width 130
        with [get-palette-entry EClass] {
            mouse-move 44 15 button1 -height 20 -width 130
            mouse-press 44 15 button1 -height 20 -width 130
            mouse-release 44 15 button1 524288 -height 20 -width 130
        }
    }
    with [get-diagram -index 1] {
        mouse-move 195 70 button1 -height 447 -width 570
        mouse-press 195 70 button1 -height 447 -width 570
        mouse-release 195 70 button1 524288 -height 447 -width 570
    }
    with [get-diagram -index 1 | get-edit-part -name newDiagram | get-edit-part -className ContainerShapeEditPart] {
        activate-direct-edit
        mouse-hover 5 0 -height 50 -width 106
    }
    with [get-editbox] {
        set-text "jo`"
        key-type Enter
    }
    with [get-diagram -index 1] {
        commit-direct-edit
        mouse-move 511 70 -height 447 -width 570
    }
    with [get-palette] {
        get-palette-entry "Standard tools" | mouse-move 1 48 -height 50 -width 130
        get-palette-entry Connections | mouse-move 60 12 -height 46 -width 130
        get-palette-entry EReference | mouse-move 102 3 -height 20 -width 130
        with [get-palette-entry EClass] {
            mouse-move 71 5 -height 20 -width 130
            mouse-press 71 5 button1 -height 20 -width 130
            mouse-move 71 5 -height 20 -width 130
            mouse-release 71 5 button1 524288 -height 20 -width 130
        }
    }
    with [get-diagram -index 1] {
        mouse-move 337 208 -height 447 -width 570
        mouse-press 337 208 button1 -height 447 -width 570
        mouse-release 337 208 button1 524288 -height 447 -width 570
    }
    get-diagram -index 1 | get-edit-part -name newDiagram | get-edit-part -className ContainerShapeEditPart -index 1 
        | activate-direct-edit
    get-editbox | set-text " ;"
    get-diagram -index 1 | get-edit-part -name newDiagram | get-edit-part -className ContainerShapeEditPart -index 1 
        | get-handle GFCornerHandle -index 3 | mouse-hover 0 1 -height 5 -width 5
    with [get-editbox] {
        set-text "jeoa"
        key-type Enter
    }
    get-diagram -index 1 | commit-direct-edit
}

with [get-editor newDiagram] {
    with [get-diagram -index 1] {
        get-edit-part -name newDiagram | get-edit-part -text jeoa | mouse-move 93 18 -height 50 -width 106
        get-figure "3/9" | mouse-move 103 48 -height 83 -width 133
        with [get-figure "3/9/3"] {
            mouse-move 15 8 -height 20 -width 20
            mouse-hover 15 8 -height 20 -width 20
            mouse-press 15 8 button1 -height 20 -width 20
        }
        get-figure "3/9/3" | mouse-press 15 8 button1 -height 20 -width 20
        mouse-move 460 107 -mask 524288 -height 447 -width 570
        mouse-move 232 65 -mask 524288 -height 447 -width 570
        get-edit-part -name newDiagram | get-edit-part -text "jo`" | mouse-move 34 4 -mask 524288 -height 50 -width 106
        get-figure "0/1/0/0/0/0" | mouse-move 29 18 -mask 524288 -height 50 -width 100
        get-edit-part -name newDiagram | get-edit-part -text "jo`" | mouse-hover 29 18 -height 50 -width 106
        with [get-figure "0/1/0/0/0/0"] {
            mouse-hover 29 18 -height 50 -width 100
            mouse-move 27 41 -mask 524288 -height 50 -width 100
        }
        get-edit-part -name newDiagram | get-edit-part -text "jo`" | mouse-hover 27 41 -height 50 -width 106
        get-figure "0/1/0/0/0/0" | mouse-hover 27 41 -height 50 -width 100
        mouse-move 222 124 -mask 524288 -height 447 -width 570
        mouse-move 222 123 -mask 524288 -height 447 -width 570
        mouse-move 222 122 -mask 524288 -height 447 -width 570
        mouse-move 222 120 -mask 524288 -height 447 -width 570
        get-figure "0/1/0/0/0/0" | mouse-move 32 38 -mask 524288 -height 50 -width 100
        get-edit-part -name newDiagram | get-edit-part -text "jo`" | mouse-hover 32 38 -height 50 -width 106
        get-figure "0/1/0/0/0/0" | mouse-hover 32 38 -height 50 -width 100
        mouse-move 216 299 -mask 524288 -height 447 -width 570
        mouse-move 216 298 -mask 524288 -height 447 -width 570
        mouse-move 216 297 -mask 524288 -height 447 -width 570
        mouse-move 214 294 -mask 524288 -height 447 -width 570
        mouse-move 214 293 -mask 524288 -height 447 -width 570
        mouse-move 214 291 -mask 524288 -height 447 -width 570
        mouse-move 213 290 -mask 524288 -height 447 -width 570
        mouse-move 212 288 -mask 524288 -height 447 -width 570
        mouse-move 212 281 -mask 524288 -height 447 -width 570
        mouse-move 212 277 -mask 524288 -height 447 -width 570
        mouse-move 212 266 -mask 524288 -height 447 -width 570
        mouse-move 212 264 -mask 524288 -height 447 -width 570
        mouse-move 229 168 -mask 524288 -height 447 -width 570
        mouse-move 229 166 -mask 524288 -height 447 -width 570
        mouse-move 229 165 -mask 524288 -height 447 -width 570
        mouse-move 229 164 -mask 524288 -height 447 -width 570
        mouse-move 229 163 -mask 524288 -height 447 -width 570
        mouse-move 229 162 -mask 524288 -height 447 -width 570
        mouse-move 229 161 -mask 524288 -height 447 -width 570
        mouse-move 229 160 -mask 524288 -height 447 -width 570
        mouse-move 229 159 -mask 524288 -height 447 -width 570
        mouse-move 229 157 -mask 524288 -height 447 -width 570
        get-figure "0/1/0/0/0/0" | mouse-move 41 34 -mask 524288 -height 50 -width 100
        get-edit-part -name newDiagram | get-edit-part -text "jo`" | mouse-hover 41 34 -height 50 -width 106
        with [get-figure "0/1/0/0/0/0"] {
            mouse-hover 41 34 -height 50 -width 100
            mouse-move 41 32 -mask 524288 -height 50 -width 100
        }
        get-edit-part -name newDiagram | get-edit-part -text "jo`" | mouse-hover 41 32 -height 50 -width 106
        with [get-figure "0/1/0/0/0/0"] {
            mouse-hover 41 32 -height 50 -width 100
            mouse-move 41 37 -mask 524288 -height 50 -width 100
        }
        get-edit-part -name newDiagram | get-edit-part -text "jo`" | mouse-hover 41 37 -height 50 -width 106
        get-figure "0/1/0/0/0/0" | mouse-hover 41 37 -height 50 -width 100
        mouse-move 226 142 -mask 524288 -height 447 -width 570
        mouse-move 225 175 -mask 524288 -height 447 -width 570
        mouse-move 225 177 -mask 524288 -height 447 -width 570
        mouse-move 224 177 -mask 524288 -height 447 -width 570
        get-figure "1/0" | mouse-move 0 1 -mask 524288 -height 43 -width 117
        mouse-hover 224 177 -height 447 -width 570
        get-figure "1/0" | mouse-hover 1 1 -height 43 -width 118
        mouse-move 224 174 -mask 524288 -height 447 -width 570
        mouse-move 224 173 -mask 524288 -height 447 -width 570
        mouse-move 224 172 -mask 524288 -height 447 -width 570
        mouse-move 224 171 -mask 524288 -height 447 -width 570
        mouse-move 224 170 -mask 524288 -height 447 -width 570
        mouse-move 224 169 -mask 524288 -height 447 -width 570
        mouse-move 224 168 -mask 524288 -height 447 -width 570
        mouse-move 224 166 -mask 524288 -height 447 -width 570
        mouse-move 224 165 -mask 524288 -height 447 -width 570
        mouse-move 224 163 -mask 524288 -height 447 -width 570
        mouse-move 224 162 -mask 524288 -height 447 -width 570
        get-figure "1/0" | mouse-move 1 0 -mask 524288 -height 53 -width 118
        mouse-hover 224 162 -height 447 -width 570
        get-figure "1/0" | mouse-hover 1 1 -height 53 -width 118
        mouse-move 224 164 -mask 524288 -height 447 -width 570
        mouse-move 224 166 -mask 524288 -height 447 -width 570
        mouse-move 224 167 -mask 524288 -height 447 -width 570
        mouse-move 224 169 -mask 524288 -height 447 -width 570
        mouse-move 224 170 -mask 524288 -height 447 -width 570
        mouse-move 224 171 -mask 524288 -height 447 -width 570
        mouse-move 224 172 -mask 524288 -height 447 -width 570
        mouse-move 225 173 -mask 524288 -height 447 -width 570
        mouse-move 225 175 -mask 524288 -height 447 -width 570
        mouse-move 225 176 -mask 524288 -height 447 -width 570
        get-figure "1/0" | mouse-move 1 2 -mask 524288 -height 44 -width 117
        mouse-hover 225 176 -height 447 -width 570
        get-figure "1/0" | mouse-hover 1 1 -height 44 -width 117
        mouse-move 225 175 -mask 524288 -height 447 -width 570
        mouse-move 225 173 -mask 524288 -height 447 -width 570
        mouse-move 225 172 -mask 524288 -height 447 -width 570
        mouse-move 225 171 -mask 524288 -height 447 -width 570
        mouse-move 225 170 -mask 524288 -height 447 -width 570
        mouse-move 225 169 -mask 524288 -height 447 -width 570
        mouse-move 225 168 -mask 524288 -height 447 -width 570
        mouse-move 225 167 -mask 524288 -height 447 -width 570
        get-figure "1/0" | mouse-move 1 0 -mask 524288 -height 49 -width 117
        mouse-hover 225 167 -height 447 -width 570
        with [get-figure "1/0"] {
            mouse-hover 1 1 -height 50 -width 117
            mouse-move 1 2 -mask 524288 -height 50 -width 117
        }
        mouse-hover 225 168 -height 447 -width 570
        get-figure "1/0" | mouse-hover 1 1 -height 49 -width 117
        mouse-move 223 168 -mask 524288 -height 447 -width 570
        mouse-move 221 168 -mask 524288 -height 447 -width 570
        mouse-move 220 168 -mask 524288 -height 447 -width 570
        mouse-move 220 169 -mask 524288 -height 447 -width 570
        mouse-move 220 170 -mask 524288 -height 447 -width 570
        mouse-move 222 170 -mask 524288 -height 447 -width 570
        mouse-move 223 170 -mask 524288 -height 447 -width 570
        mouse-move 223 171 -mask 524288 -height 447 -width 570
        mouse-move 224 171 -mask 524288 -height 447 -width 570
        mouse-move 225 171 -mask 524288 -height 447 -width 570
        mouse-move 226 171 -mask 524288 -height 447 -width 570
        mouse-move 226 170 -mask 524288 -height 447 -width 570
        mouse-move 226 169 -mask 524288 -height 447 -width 570
        mouse-move 226 168 -mask 524288 -height 447 -width 570
        mouse-move 226 167 -mask 524288 -height 447 -width 570
        mouse-move 225 167 -mask 524288 -height 447 -width 570
        mouse-move 224 167 -mask 524288 -height 447 -width 570
        mouse-move 223 167 -mask 524288 -height 447 -width 570
        mouse-move 222 167 -mask 524288 -height 447 -width 570
        mouse-move 221 167 -mask 524288 -height 447 -width 570
        mouse-move 221 168 -mask 524288 -height 447 -width 570
        mouse-move 221 169 -mask 524288 -height 447 -width 570
        mouse-move 221 170 -mask 524288 -height 447 -width 570
        mouse-move 221 171 -mask 524288 -height 447 -width 570
        mouse-move 221 173 -mask 524288 -height 447 -width 570
        mouse-move 221 173 -mask 524288 -height 447 -width 570
        mouse-move 222 173 -mask 524288 -height 447 -width 570
        mouse-move 223 173 -mask 524288 -height 447 -width 570
        mouse-move 224 173 -mask 524288 -height 447 -width 570
        mouse-move 224 172 -mask 524288 -height 447 -width 570
        mouse-move 224 170 -mask 524288 -height 447 -width 570
        mouse-move 224 169 -mask 524288 -height 447 -width 570
        mouse-move 224 168 -mask 524288 -height 447 -width 570
        mouse-move 224 167 -mask 524288 -height 447 -width 570
        mouse-move 224 166 -mask 524288 -height 447 -width 570
        mouse-move 223 166 -mask 524288 -height 447 -width 570
        mouse-move 223 166 -mask 524288 -height 447 -width 570
        mouse-move 222 166 -mask 524288 -height 447 -width 570
        mouse-move 221 166 -mask 524288 -height 447 -width 570
        mouse-move 220 166 -mask 524288 -height 447 -width 570
        mouse-move 220 167 -mask 524288 -height 447 -width 570
        mouse-move 220 168 -mask 524288 -height 447 -width 570
        mouse-move 220 169 -mask 524288 -height 447 -width 570
        mouse-move 220 170 -mask 524288 -height 447 -width 570
        mouse-move 220 172 -mask 524288 -height 447 -width 570
        mouse-move 221 172 -mask 524288 -height 447 -width 570
        mouse-move 222 172 -mask 524288 -height 447 -width 570
        mouse-move 223 172 -mask 524288 -height 447 -width 570
        mouse-move 223 171 -mask 524288 -height 447 -width 570
        mouse-move 223 170 -mask 524288 -height 447 -width 570
        mouse-move 223 168 -mask 524288 -height 447 -width 570
        mouse-move 223 167 -mask 524288 -height 447 -width 570
        mouse-move 222 167 -mask 524288 -height 447 -width 570
        mouse-move 220 167 -mask 524288 -height 447 -width 570
        mouse-move 219 167 -mask 524288 -height 447 -width 570
        mouse-move 219 168 -mask 524288 -height 447 -width 570
        mouse-move 219 169 -mask 524288 -height 447 -width 570
        mouse-move 219 170 -mask 524288 -height 447 -width 570
        mouse-move 219 172 -mask 524288 -height 447 -width 570
        mouse-move 219 174 -mask 524288 -height 447 -width 570
        mouse-move 219 175 -mask 524288 -height 447 -width 570
        mouse-move 220 175 -mask 524288 -height 447 -width 570
        mouse-move 221 175 -mask 524288 -height 447 -width 570
        mouse-move 222 175 -mask 524288 -height 447 -width 570
        mouse-move 222 174 -mask 524288 -height 447 -width 570
        mouse-move 223 173 -mask 524288 -height 447 -width 570
        mouse-move 223 172 -mask 524288 -height 447 -width 570
        mouse-move 223 171 -mask 524288 -height 447 -width 570
        mouse-move 223 170 -mask 524288 -height 447 -width 570
        mouse-move 223 169 -mask 524288 -height 447 -width 570
        mouse-move 223 168 -mask 524288 -height 447 -width 570
        mouse-move 223 167 -mask 524288 -height 447 -width 570
        mouse-move 223 166 -mask 524288 -height 447 -width 570
        mouse-move 223 165 -mask 524288 -height 447 -width 570
        mouse-move 223 164 -mask 524288 -height 447 -width 570
        mouse-move 223 164 -mask 524288 -height 447 -width 570
        mouse-move 222 164 -mask 524288 -height 447 -width 570
        mouse-move 221 164 -mask 524288 -height 447 -width 570
        mouse-move 219 164 -mask 524288 -height 447 -width 570
        mouse-move 218 164 -mask 524288 -height 447 -width 570
        mouse-move 217 164 -mask 524288 -height 447 -width 570
        mouse-move 216 164 -mask 524288 -height 447 -width 570
        mouse-move 215 164 -mask 524288 -height 447 -width 570
        mouse-move 214 164 -mask 524288 -height 447 -width 570
        mouse-move 213 164 -mask 524288 -height 447 -width 570
        mouse-move 213 165 -mask 524288 -height 447 -width 570
        mouse-move 213 166 -mask 524288 -height 447 -width 570
        mouse-move 213 167 -mask 524288 -height 447 -width 570
        mouse-move 213 168 -mask 524288 -height 447 -width 570
        mouse-move 213 169 -mask 524288 -height 447 -width 570
        mouse-move 213 170 -mask 524288 -height 447 -width 570
        mouse-move 213 171 -mask 524288 -height 447 -width 570
        mouse-move 213 172 -mask 524288 -height 447 -width 570
        mouse-move 213 173 -mask 524288 -height 447 -width 570
        mouse-move 213 174 -mask 524288 -height 447 -width 570
        mouse-move 213 175 -mask 524288 -height 447 -width 570
        mouse-move 214 175 -mask 524288 -height 447 -width 570
        mouse-move 215 175 -mask 524288 -height 447 -width 570
        mouse-move 216 175 -mask 524288 -height 447 -width 570
        mouse-move 217 175 -mask 524288 -height 447 -width 570
        mouse-move 218 175 -mask 524288 -height 447 -width 570
        mouse-move 219 175 -mask 524288 -height 447 -width 570
        mouse-move 220 175 -mask 524288 -height 447 -width 570
        mouse-move 220 174 -mask 524288 -height 447 -width 570
        mouse-move 221 173 -mask 524288 -height 447 -width 570
        mouse-move 222 172 -mask 524288 -height 447 -width 570
        mouse-move 222 171 -mask 524288 -height 447 -width 570
        mouse-move 222 169 -mask 524288 -height 447 -width 570
        mouse-move 222 168 -mask 524288 -height 447 -width 570
        mouse-move 222 167 -mask 524288 -height 447 -width 570
        mouse-move 222 166 -mask 524288 -height 447 -width 570
        mouse-move 222 164 -mask 524288 -height 447 -width 570
        mouse-move 222 163 -mask 524288 -height 447 -width 570
        mouse-move 221 162 -mask 524288 -height 447 -width 570
        mouse-move 220 162 -mask 524288 -height 447 -width 570
        mouse-move 220 161 -mask 524288 -height 447 -width 570
        mouse-move 219 161 -mask 524288 -height 447 -width 570
        mouse-move 218 160 -mask 524288 -height 447 -width 570
        mouse-move 218 159 -mask 524288 -height 447 -width 570
        mouse-move 216 159 -mask 524288 -height 447 -width 570
        mouse-move 215 158 -mask 524288 -height 447 -width 570
        mouse-move 214 158 -mask 524288 -height 447 -width 570
        mouse-move 213 158 -mask 524288 -height 447 -width 570
        mouse-move 212 158 -mask 524288 -height 447 -width 570
        mouse-move 211 158 -mask 524288 -height 447 -width 570
        mouse-move 209 158 -mask 524288 -height 447 -width 570
        mouse-move 209 159 -mask 524288 -height 447 -width 570
        mouse-move 209 161 -mask 524288 -height 447 -width 570
        mouse-move 209 162 -mask 524288 -height 447 -width 570
        mouse-move 209 164 -mask 524288 -height 447 -width 570
        mouse-move 209 166 -mask 524288 -height 447 -width 570
        mouse-move 209 168 -mask 524288 -height 447 -width 570
        mouse-move 209 169 -mask 524288 -height 447 -width 570
        mouse-move 209 170 -mask 524288 -height 447 -width 570
        mouse-move 210 171 -mask 524288 -height 447 -width 570
        mouse-move 211 171 -mask 524288 -height 447 -width 570
        mouse-move 212 172 -mask 524288 -height 447 -width 570
        mouse-move 212 173 -mask 524288 -height 447 -width 570
        mouse-move 213 175 -mask 524288 -height 447 -width 570
        mouse-move 215 175 -mask 524288 -height 447 -width 570
        mouse-move 216 175 -mask 524288 -height 447 -width 570
        mouse-move 217 175 -mask 524288 -height 447 -width 570
        mouse-move 218 174 -mask 524288 -height 447 -width 570
        mouse-move 218 172 -mask 524288 -height 447 -width 570
        mouse-move 218 171 -mask 524288 -height 447 -width 570
        mouse-move 218 168 -mask 524288 -height 447 -width 570
        mouse-move 218 167 -mask 524288 -height 447 -width 570
        mouse-move 220 167 -mask 524288 -height 447 -width 570
        mouse-move 220 165 -mask 524288 -height 447 -width 570
        mouse-move 220 163 -mask 524288 -height 447 -width 570
        mouse-move 220 161 -mask 524288 -height 447 -width 570
        mouse-move 220 160 -mask 524288 -height 447 -width 570
        mouse-move 219 158 -mask 524288 -height 447 -width 570
        mouse-move 218 156 -mask 524288 -height 447 -width 570
        mouse-move 215 155 -mask 524288 -height 447 -width 570
        mouse-move 214 155 -mask 524288 -height 447 -width 570
        mouse-move 213 155 -mask 524288 -height 447 -width 570
        mouse-move 212 154 -mask 524288 -height 447 -width 570
        mouse-move 211 154 -mask 524288 -height 447 -width 570
        mouse-move 210 154 -mask 524288 -height 447 -width 570
        mouse-move 209 154 -mask 524288 -height 447 -width 570
        mouse-move 208 154 -mask 524288 -height 447 -width 570
        mouse-move 208 155 -mask 524288 -height 447 -width 570
        mouse-move 207 155 -mask 524288 -height 447 -width 570
        mouse-move 207 156 -mask 524288 -height 447 -width 570
        mouse-move 206 157 -mask 524288 -height 447 -width 570
        mouse-move 206 159 -mask 524288 -height 447 -width 570
        mouse-move 206 163 -mask 524288 -height 447 -width 570
        mouse-move 206 166 -mask 524288 -height 447 -width 570
        mouse-move 207 167 -mask 524288 -height 447 -width 570
        mouse-move 208 169 -mask 524288 -height 447 -width 570
        mouse-move 209 171 -mask 524288 -height 447 -width 570
        mouse-move 211 175 -mask 524288 -height 447 -width 570
        mouse-move 212 175 -mask 524288 -height 447 -width 570
        mouse-move 213 176 -mask 524288 -height 447 -width 570
        mouse-move 215 176 -mask 524288 -height 447 -width 570
        mouse-move 216 176 -mask 524288 -height 447 -width 570
        mouse-move 217 176 -mask 524288 -height 447 -width 570
        mouse-move 219 176 -mask 524288 -height 447 -width 570
        mouse-move 220 176 -mask 524288 -height 447 -width 570
        mouse-move 221 176 -mask 524288 -height 447 -width 570
        mouse-move 221 175 -mask 524288 -height 447 -width 570
        mouse-move 222 173 -mask 524288 -height 447 -width 570
        mouse-move 222 172 -mask 524288 -height 447 -width 570
        mouse-move 222 171 -mask 524288 -height 447 -width 570
        mouse-move 222 169 -mask 524288 -height 447 -width 570
        mouse-move 222 167 -mask 524288 -height 447 -width 570
        mouse-move 222 166 -mask 524288 -height 447 -width 570
        mouse-move 222 165 -mask 524288 -height 447 -width 570
        mouse-move 222 164 -mask 524288 -height 447 -width 570
        mouse-move 222 163 -mask 524288 -height 447 -width 570
        mouse-move 222 161 -mask 524288 -height 447 -width 570
        mouse-move 222 160 -mask 524288 -height 447 -width 570
        mouse-move 222 159 -mask 524288 -height 447 -width 570
        mouse-move 220 159 -mask 524288 -height 447 -width 570
        mouse-move 219 158 -mask 524288 -height 447 -width 570
        mouse-move 218 158 -mask 524288 -height 447 -width 570
        mouse-move 217 157 -mask 524288 -height 447 -width 570
        mouse-move 215 157 -mask 524288 -height 447 -width 570
        mouse-move 214 157 -mask 524288 -height 447 -width 570
        mouse-move 212 157 -mask 524288 -height 447 -width 570
        mouse-move 211 157 -mask 524288 -height 447 -width 570
        mouse-move 210 157 -mask 524288 -height 447 -width 570
        mouse-move 208 157 -mask 524288 -height 447 -width 570
        mouse-move 207 157 -mask 524288 -height 447 -width 570
        mouse-move 206 157 -mask 524288 -height 447 -width 570
        mouse-move 206 158 -mask 524288 -height 447 -width 570
        mouse-move 205 158 -mask 524288 -height 447 -width 570
        mouse-move 205 160 -mask 524288 -height 447 -width 570
        mouse-move 205 161 -mask 524288 -height 447 -width 570
        mouse-move 205 163 -mask 524288 -height 447 -width 570
        mouse-move 205 167 -mask 524288 -height 447 -width 570
        mouse-move 205 168 -mask 524288 -height 447 -width 570
        mouse-move 205 177 -mask 524288 -height 447 -width 570
        mouse-move 205 178 -mask 524288 -height 447 -width 570
        mouse-move 205 180 -mask 524288 -height 447 -width 570
        mouse-move 207 182 -mask 524288 -height 447 -width 570
        mouse-move 208 183 -mask 524288 -height 447 -width 570
        mouse-move 209 184 -mask 524288 -height 447 -width 570
        mouse-move 210 185 -mask 524288 -height 447 -width 570
        mouse-move 212 185 -mask 524288 -height 447 -width 570
        mouse-move 212 186 -mask 524288 -height 447 -width 570
        mouse-move 215 186 -mask 524288 -height 447 -width 570
        mouse-move 216 186 -mask 524288 -height 447 -width 570
        mouse-move 217 186 -mask 524288 -height 447 -width 570
        mouse-move 218 186 -mask 524288 -height 447 -width 570
        mouse-move 218 186 -mask 524288 -height 447 -width 570
        mouse-move 218 185 -mask 524288 -height 447 -width 570
        mouse-move 219 183 -mask 524288 -height 447 -width 570
        mouse-move 219 182 -mask 524288 -height 447 -width 570
        mouse-move 220 179 -mask 524288 -height 447 -width 570
        mouse-move 220 178 -mask 524288 -height 447 -width 570
        mouse-move 220 174 -mask 524288 -height 447 -width 570
        mouse-move 220 173 -mask 524288 -height 447 -width 570
        mouse-move 220 171 -mask 524288 -height 447 -width 570
        mouse-move 220 166 -mask 524288 -height 447 -width 570
        mouse-move 217 161 -mask 524288 -height 447 -width 570
        mouse-move 216 160 -mask 524288 -height 447 -width 570
        mouse-move 211 156 -mask 524288 -height 447 -width 570
        mouse-move 207 155 -mask 524288 -height 447 -width 570
        mouse-move 201 152 -mask 524288 -height 447 -width 570
        mouse-move 194 152 -mask 524288 -height 447 -width 570
        mouse-move 144 238 -mask 524288 -height 447 -width 570
        mouse-move 149 239 -mask 524288 -height 447 -width 570
        mouse-move 152 239 -mask 524288 -height 447 -width 570
        mouse-move 157 239 -mask 524288 -height 447 -width 570
        mouse-move 167 233 -mask 524288 -height 447 -width 570
        mouse-move 171 229 -mask 524288 -height 447 -width 570
        mouse-move 176 223 -mask 524288 -height 447 -width 570
        mouse-move 176 222 -mask 524288 -height 447 -width 570
        mouse-move 177 221 -mask 524288 -height 447 -width 570
        mouse-move 178 220 -mask 524288 -height 447 -width 570
        mouse-move 179 219 -mask 524288 -height 447 -width 570
        mouse-move 180 219 -mask 524288 -height 447 -width 570
        mouse-hover 180 219 -height 447 -width 570
        get-figure "1/0" | mouse-hover 1 1 -height 15 -width 162
        mouse-move 180 217 -mask 524288 -height 447 -width 570
        mouse-move 180 216 -mask 524288 -height 447 -width 570
        mouse-move 176 210 -mask 524288 -height 447 -width 570
        mouse-move 174 208 -mask 524288 -height 447 -width 570
        mouse-move 174 206 -mask 524288 -height 447 -width 570
        mouse-move 173 205 -mask 524288 -height 447 -width 570
        mouse-move 172 205 -mask 524288 -height 447 -width 570
        mouse-move 171 204 -mask 524288 -height 447 -width 570
        get-figure "1/0" | mouse-move 0 0 -mask 524288 -height 26 -width 170
        mouse-hover 171 204 -height 447 -width 570
        get-figure "1/0" | mouse-hover 1 1 -height 26 -width 171
        mouse-move 171 206 -mask 524288 -height 447 -width 570
        mouse-move 171 208 -mask 524288 -height 447 -width 570
        mouse-move 171 245 -mask 524288 -height 447 -width 570
        mouse-move 171 246 -mask 524288 -height 447 -width 570
        mouse-move 172 247 -mask 524288 -height 447 -width 570
        mouse-move 173 247 -mask 524288 -height 447 -width 570
        mouse-move 173 248 -mask 524288 -height 447 -width 570
        mouse-move 174 248 -mask 524288 -height 447 -width 570
        mouse-move 175 248 -mask 524288 -height 447 -width 570
        mouse-move 177 248 -mask 524288 -height 447 -width 570
        mouse-move 180 248 -mask 524288 -height 447 -width 570
        mouse-move 186 249 -mask 524288 -height 447 -width 570
        mouse-move 189 251 -mask 524288 -height 447 -width 570
        mouse-move 201 253 -mask 524288 -height 447 -width 570
        mouse-move 205 253 -mask 524288 -height 447 -width 570
        mouse-move 209 253 -mask 524288 -height 447 -width 570
        mouse-move 210 253 -mask 524288 -height 447 -width 570
        mouse-move 211 252 -mask 524288 -height 447 -width 570
        mouse-move 213 251 -mask 524288 -height 447 -width 570
        mouse-move 216 245 -mask 524288 -height 447 -width 570
        mouse-move 216 238 -mask 524288 -height 447 -width 570
        mouse-move 217 236 -mask 524288 -height 447 -width 570
        mouse-move 218 227 -mask 524288 -height 447 -width 570
        mouse-move 218 225 -mask 524288 -height 447 -width 570
        mouse-move 218 224 -mask 524288 -height 447 -width 570
        mouse-move 218 219 -mask 524288 -height 447 -width 570
        mouse-move 218 218 -mask 524288 -height 447 -width 570
        mouse-move 218 216 -mask 524288 -height 447 -width 570
        mouse-move 218 214 -mask 524288 -height 447 -width 570
        mouse-move 218 213 -mask 524288 -height 447 -width 570
        mouse-move 218 211 -mask 524288 -height 447 -width 570
        mouse-move 218 210 -mask 524288 -height 447 -width 570
        mouse-move 218 208 -mask 524288 -height 447 -width 570
        mouse-move 217 207 -mask 524288 -height 447 -width 570
        mouse-move 216 206 -mask 524288 -height 447 -width 570
        mouse-move 216 205 -mask 524288 -height 447 -width 570
        mouse-move 215 204 -mask 524288 -height 447 -width 570
        mouse-move 215 203 -mask 524288 -height 447 -width 570
        mouse-move 214 202 -mask 524288 -height 447 -width 570
        mouse-move 214 201 -mask 524288 -height 447 -width 570
        mouse-move 213 201 -mask 524288 -height 447 -width 570
        mouse-move 212 200 -mask 524288 -height 447 -width 570
        mouse-move 212 198 -mask 524288 -height 447 -width 570
        mouse-move 210 197 -mask 524288 -height 447 -width 570
        mouse-move 209 197 -mask 524288 -height 447 -width 570
        mouse-move 207 196 -mask 524288 -height 447 -width 570
        mouse-move 205 195 -mask 524288 -height 447 -width 570
        mouse-move 205 194 -mask 524288 -height 447 -width 570
        mouse-move 203 193 -mask 524288 -height 447 -width 570
        mouse-move 198 191 -mask 524288 -height 447 -width 570
        mouse-move 193 188 -mask 524288 -height 447 -width 570
        mouse-move 190 188 -mask 524288 -height 447 -width 570
        mouse-move 189 188 -mask 524288 -height 447 -width 570
        mouse-move 187 188 -mask 524288 -height 447 -width 570
        mouse-move 185 188 -mask 524288 -height 447 -width 570
        mouse-move 181 188 -mask 524288 -height 447 -width 570
        mouse-move 179 188 -mask 524288 -height 447 -width 570
        mouse-move 177 189 -mask 524288 -height 447 -width 570
        mouse-move 176 191 -mask 524288 -height 447 -width 570
        mouse-move 175 192 -mask 524288 -height 447 -width 570
        mouse-move 173 198 -mask 524288 -height 447 -width 570
        mouse-move 172 205 -mask 524288 -height 447 -width 570
        mouse-move 172 206 -mask 524288 -height 447 -width 570
        mouse-move 172 210 -mask 524288 -height 447 -width 570
        mouse-move 172 211 -mask 524288 -height 447 -width 570
        mouse-move 172 212 -mask 524288 -height 447 -width 570
        mouse-move 172 213 -mask 524288 -height 447 -width 570
        mouse-move 173 213 -mask 524288 -height 447 -width 570
        mouse-move 175 213 -mask 524288 -height 447 -width 570
        mouse-move 176 213 -mask 524288 -height 447 -width 570
        mouse-move 178 213 -mask 524288 -height 447 -width 570
        mouse-move 180 213 -mask 524288 -height 447 -width 570
        mouse-move 182 213 -mask 524288 -height 447 -width 570
        mouse-move 189 200 -mask 524288 -height 447 -width 570
        mouse-move 189 199 -mask 524288 -height 447 -width 570
        mouse-move 189 194 -mask 524288 -height 447 -width 570
        mouse-move 189 192 -mask 524288 -height 447 -width 570
        mouse-move 189 191 -mask 524288 -height 447 -width 570
        mouse-move 188 191 -mask 524288 -height 447 -width 570
        mouse-move 187 190 -mask 524288 -height 447 -width 570
        mouse-move 186 189 -mask 524288 -height 447 -width 570
        mouse-move 186 188 -mask 524288 -height 447 -width 570
        mouse-move 184 188 -mask 524288 -height 447 -width 570
        mouse-move 183 187 -mask 524288 -height 447 -width 570
        mouse-move 182 187 -mask 524288 -height 447 -width 570
        mouse-move 181 187 -mask 524288 -height 447 -width 570
        mouse-move 180 187 -mask 524288 -height 447 -width 570
        mouse-move 180 188 -mask 524288 -height 447 -width 570
        mouse-move 180 190 -mask 524288 -height 447 -width 570
        mouse-move 180 191 -mask 524288 -height 447 -width 570
        mouse-move 180 192 -mask 524288 -height 447 -width 570
        mouse-move 180 194 -mask 524288 -height 447 -width 570
        mouse-move 180 195 -mask 524288 -height 447 -width 570
        mouse-move 180 196 -mask 524288 -height 447 -width 570
        mouse-move 181 196 -mask 524288 -height 447 -width 570
        mouse-move 182 196 -mask 524288 -height 447 -width 570
        mouse-move 183 196 -mask 524288 -height 447 -width 570
        mouse-move 184 196 -mask 524288 -height 447 -width 570
        mouse-move 185 196 -mask 524288 -height 447 -width 570
        mouse-move 185 195 -mask 524288 -height 447 -width 570
        mouse-move 185 194 -mask 524288 -height 447 -width 570
        mouse-move 185 193 -mask 524288 -height 447 -width 570
        mouse-move 185 192 -mask 524288 -height 447 -width 570
        mouse-move 185 191 -mask 524288 -height 447 -width 570
        mouse-move 185 190 -mask 524288 -height 447 -width 570
        mouse-move 185 189 -mask 524288 -height 447 -width 570
        mouse-move 185 188 -mask 524288 -height 447 -width 570
        mouse-move 184 188 -mask 524288 -height 447 -width 570
        mouse-move 182 188 -mask 524288 -height 447 -width 570
        mouse-move 181 188 -mask 524288 -height 447 -width 570
        mouse-move 180 188 -mask 524288 -height 447 -width 570
        mouse-move 179 188 -mask 524288 -height 447 -width 570
        mouse-move 178 189 -mask 524288 -height 447 -width 570
        mouse-move 178 190 -mask 524288 -height 447 -width 570
        mouse-move 178 191 -mask 524288 -height 447 -width 570
        mouse-move 178 192 -mask 524288 -height 447 -width 570
        mouse-move 178 193 -mask 524288 -height 447 -width 570
        mouse-move 178 194 -mask 524288 -height 447 -width 570
        mouse-move 178 195 -mask 524288 -height 447 -width 570
        mouse-move 178 196 -mask 524288 -height 447 -width 570
        mouse-move 178 197 -mask 524288 -height 447 -width 570
        mouse-move 179 197 -mask 524288 -height 447 -width 570
        mouse-move 180 197 -mask 524288 -height 447 -width 570
        mouse-move 181 197 -mask 524288 -height 447 -width 570
        mouse-move 182 197 -mask 524288 -height 447 -width 570
        mouse-move 182 196 -mask 524288 -height 447 -width 570
        mouse-move 182 195 -mask 524288 -height 447 -width 570
        mouse-move 182 194 -mask 524288 -height 447 -width 570
        mouse-move 182 192 -mask 524288 -height 447 -width 570
        mouse-move 182 191 -mask 524288 -height 447 -width 570
        mouse-move 182 190 -mask 524288 -height 447 -width 570
        mouse-move 182 189 -mask 524288 -height 447 -width 570
        mouse-move 181 189 -mask 524288 -height 447 -width 570
        mouse-move 181 190 -mask 524288 -height 447 -width 570
        mouse-move 181 191 -mask 524288 -height 447 -width 570
        mouse-move 181 192 -mask 524288 -height 447 -width 570
        mouse-move 181 193 -mask 524288 -height 447 -width 570
        mouse-move 181 195 -mask 524288 -height 447 -width 570
        mouse-move 181 196 -mask 524288 -height 447 -width 570
        mouse-move 181 197 -mask 524288 -height 447 -width 570
        mouse-move 181 198 -mask 524288 -height 447 -width 570
        mouse-move 182 198 -mask 524288 -height 447 -width 570
        mouse-move 183 198 -mask 524288 -height 447 -width 570
        mouse-move 184 198 -mask 524288 -height 447 -width 570
        mouse-move 184 197 -mask 524288 -height 447 -width 570
        mouse-move 184 196 -mask 524288 -height 447 -width 570
        mouse-move 184 195 -mask 524288 -height 447 -width 570
        mouse-move 184 193 -mask 524288 -height 447 -width 570
        mouse-move 184 192 -mask 524288 -height 447 -width 570
        mouse-move 183 192 -mask 524288 -height 447 -width 570
        mouse-move 182 192 -mask 524288 -height 447 -width 570
        mouse-move 182 193 -mask 524288 -height 447 -width 570
        mouse-move 182 194 -mask 524288 -height 447 -width 570
        mouse-move 182 195 -mask 524288 -height 447 -width 570
        mouse-move 182 197 -mask 524288 -height 447 -width 570
        mouse-move 183 197 -mask 524288 -height 447 -width 570
        mouse-move 183 195 -mask 524288 -height 447 -width 570
        mouse-move 183 194 -mask 524288 -height 447 -width 570
        mouse-move 183 193 -mask 524288 -height 447 -width 570
        mouse-move 183 192 -mask 524288 -height 447 -width 570
        mouse-move 182 192 -mask 524288 -height 447 -width 570
        mouse-move 182 192 -mask 524288 -height 447 -width 570
        mouse-move 182 193 -mask 524288 -height 447 -width 570
        mouse-move 182 193 -mask 524288 -height 447 -width 570
        mouse-move 184 193 -mask 524288 -height 447 -width 570
        mouse-move 185 193 -mask 524288 -height 447 -width 570
        mouse-move 185 192 -mask 524288 -height 447 -width 570
        mouse-move 185 191 -mask 524288 -height 447 -width 570
        mouse-move 185 190 -mask 524288 -height 447 -width 570
        mouse-move 185 189 -mask 524288 -height 447 -width 570
        mouse-move 185 188 -mask 524288 -height 447 -width 570
        mouse-move 184 188 -mask 524288 -height 447 -width 570
        mouse-move 183 188 -mask 524288 -height 447 -width 570
        mouse-move 183 189 -mask 524288 -height 447 -width 570
        mouse-move 183 190 -mask 524288 -height 447 -width 570
        mouse-move 183 191 -mask 524288 -height 447 -width 570
        mouse-move 183 192 -mask 524288 -height 447 -width 570
        mouse-move 183 193 -mask 524288 -height 447 -width 570
        mouse-move 183 194 -mask 524288 -height 447 -width 570
        mouse-move 184 194 -mask 524288 -height 447 -width 570
        mouse-move 185 194 -mask 524288 -height 447 -width 570
        mouse-move 186 194 -mask 524288 -height 447 -width 570
        mouse-move 186 194 -mask 524288 -height 447 -width 570
        mouse-move 186 192 -mask 524288 -height 447 -width 570
        mouse-move 186 191 -mask 524288 -height 447 -width 570
        mouse-move 186 190 -mask 524288 -height 447 -width 570
        mouse-move 186 189 -mask 524288 -height 447 -width 570
        mouse-move 186 188 -mask 524288 -height 447 -width 570
        mouse-move 186 188 -mask 524288 -height 447 -width 570
        mouse-move 186 189 -mask 524288 -height 447 -width 570
        mouse-move 186 190 -mask 524288 -height 447 -width 570
        mouse-move 186 191 -mask 524288 -height 447 -width 570
        mouse-move 186 192 -mask 524288 -height 447 -width 570
        mouse-move 186 193 -mask 524288 -height 447 -width 570
        mouse-move 186 194 -mask 524288 -height 447 -width 570
        mouse-move 186 195 -mask 524288 -height 447 -width 570
        mouse-move 186 196 -mask 524288 -height 447 -width 570
        mouse-move 187 196 -mask 524288 -height 447 -width 570
        mouse-move 188 196 -mask 524288 -height 447 -width 570
        mouse-move 188 195 -mask 524288 -height 447 -width 570
        mouse-move 188 194 -mask 524288 -height 447 -width 570
        mouse-move 188 193 -mask 524288 -height 447 -width 570
        mouse-move 188 192 -mask 524288 -height 447 -width 570
        mouse-move 188 191 -mask 524288 -height 447 -width 570
        mouse-move 188 190 -mask 524288 -height 447 -width 570
        mouse-move 188 189 -mask 524288 -height 447 -width 570
        mouse-move 188 188 -mask 524288 -height 447 -width 570
        mouse-move 188 187 -mask 524288 -height 447 -width 570
        mouse-move 187 187 -mask 524288 -height 447 -width 570
        mouse-move 186 187 -mask 524288 -height 447 -width 570
        mouse-move 185 187 -mask 524288 -height 447 -width 570
        mouse-move 184 187 -mask 524288 -height 447 -width 570
        mouse-move 183 187 -mask 524288 -height 447 -width 570
        mouse-move 182 187 -mask 524288 -height 447 -width 570
        mouse-move 182 188 -mask 524288 -height 447 -width 570
        mouse-move 181 189 -mask 524288 -height 447 -width 570
        mouse-move 181 190 -mask 524288 -height 447 -width 570
        mouse-move 181 191 -mask 524288 -height 447 -width 570
        mouse-move 181 192 -mask 524288 -height 447 -width 570
        mouse-move 181 193 -mask 524288 -height 447 -width 570
        mouse-move 181 195 -mask 524288 -height 447 -width 570
        mouse-move 181 196 -mask 524288 -height 447 -width 570
        mouse-move 181 197 -mask 524288 -height 447 -width 570
        mouse-move 181 198 -mask 524288 -height 447 -width 570
        mouse-move 181 199 -mask 524288 -height 447 -width 570
        mouse-move 181 200 -mask 524288 -height 447 -width 570
        mouse-move 182 200 -mask 524288 -height 447 -width 570
        mouse-move 183 200 -mask 524288 -height 447 -width 570
        mouse-move 184 200 -mask 524288 -height 447 -width 570
        mouse-move 185 200 -mask 524288 -height 447 -width 570
        mouse-move 186 199 -mask 524288 -height 447 -width 570
        mouse-move 187 198 -mask 524288 -height 447 -width 570
        mouse-move 187 197 -mask 524288 -height 447 -width 570
        mouse-move 189 197 -mask 524288 -height 447 -width 570
        mouse-move 189 196 -mask 524288 -height 447 -width 570
        mouse-move 189 195 -mask 524288 -height 447 -width 570
        mouse-move 190 194 -mask 524288 -height 447 -width 570
        mouse-move 190 193 -mask 524288 -height 447 -width 570
        mouse-move 190 191 -mask 524288 -height 447 -width 570
        mouse-move 190 190 -mask 524288 -height 447 -width 570
        mouse-move 190 189 -mask 524288 -height 447 -width 570
        mouse-move 190 188 -mask 524288 -height 447 -width 570
        mouse-move 190 187 -mask 524288 -height 447 -width 570
        mouse-move 187 187 -mask 524288 -height 447 -width 570
        mouse-move 187 186 -mask 524288 -height 447 -width 570
        mouse-move 186 186 -mask 524288 -height 447 -width 570
        mouse-move 185 186 -mask 524288 -height 447 -width 570
        mouse-move 184 186 -mask 524288 -height 447 -width 570
        mouse-move 183 186 -mask 524288 -height 447 -width 570
        mouse-move 183 187 -mask 524288 -height 447 -width 570
        mouse-move 183 188 -mask 524288 -height 447 -width 570
        mouse-move 182 189 -mask 524288 -height 447 -width 570
        mouse-move 182 190 -mask 524288 -height 447 -width 570
        mouse-move 182 192 -mask 524288 -height 447 -width 570
        mouse-move 182 194 -mask 524288 -height 447 -width 570
        mouse-move 182 196 -mask 524288 -height 447 -width 570
        mouse-move 182 198 -mask 524288 -height 447 -width 570
        mouse-move 182 201 -mask 524288 -height 447 -width 570
        mouse-move 182 202 -mask 524288 -height 447 -width 570
        mouse-move 183 202 -mask 524288 -height 447 -width 570
        mouse-move 184 202 -mask 524288 -height 447 -width 570
        mouse-move 185 202 -mask 524288 -height 447 -width 570
        mouse-move 186 202 -mask 524288 -height 447 -width 570
        mouse-move 187 202 -mask 524288 -height 447 -width 570
        mouse-move 187 202 -mask 524288 -height 447 -width 570
        mouse-move 187 201 -mask 524288 -height 447 -width 570
        mouse-move 187 199 -mask 524288 -height 447 -width 570
        mouse-move 187 198 -mask 524288 -height 447 -width 570
        mouse-move 187 196 -mask 524288 -height 447 -width 570
        mouse-move 187 194 -mask 524288 -height 447 -width 570
        mouse-move 187 193 -mask 524288 -height 447 -width 570
        mouse-move 187 192 -mask 524288 -height 447 -width 570
        mouse-move 187 191 -mask 524288 -height 447 -width 570
        mouse-move 187 190 -mask 524288 -height 447 -width 570
        mouse-move 186 190 -mask 524288 -height 447 -width 570
        mouse-move 185 190 -mask 524288 -height 447 -width 570
        mouse-move 185 189 -mask 524288 -height 447 -width 570
        mouse-move 184 189 -mask 524288 -height 447 -width 570
        mouse-move 183 189 -mask 524288 -height 447 -width 570
        mouse-move 182 189 -mask 524288 -height 447 -width 570
        mouse-move 181 189 -mask 524288 -height 447 -width 570
        mouse-move 180 189 -mask 524288 -height 447 -width 570
        mouse-move 180 189 -mask 524288 -height 447 -width 570
        mouse-move 180 191 -mask 524288 -height 447 -width 570
        mouse-move 178 192 -mask 524288 -height 447 -width 570
        mouse-move 178 193 -mask 524288 -height 447 -width 570
        mouse-move 178 194 -mask 524288 -height 447 -width 570
        mouse-move 178 196 -mask 524288 -height 447 -width 570
        mouse-move 178 197 -mask 524288 -height 447 -width 570
        mouse-move 178 198 -mask 524288 -height 447 -width 570
        mouse-move 178 199 -mask 524288 -height 447 -width 570
        mouse-move 178 201 -mask 524288 -height 447 -width 570
        mouse-move 178 202 -mask 524288 -height 447 -width 570
        mouse-move 179 202 -mask 524288 -height 447 -width 570
        mouse-move 181 202 -mask 524288 -height 447 -width 570
        mouse-move 182 202 -mask 524288 -height 447 -width 570
        mouse-move 183 202 -mask 524288 -height 447 -width 570
        mouse-move 183 203 -mask 524288 -height 447 -width 570
        mouse-move 185 203 -mask 524288 -height 447 -width 570
        mouse-move 186 203 -mask 524288 -height 447 -width 570
        mouse-move 187 203 -mask 524288 -height 447 -width 570
        mouse-move 187 202 -mask 524288 -height 447 -width 570
        mouse-move 187 201 -mask 524288 -height 447 -width 570
        mouse-move 188 200 -mask 524288 -height 447 -width 570
        mouse-move 188 199 -mask 524288 -height 447 -width 570
        mouse-move 188 198 -mask 524288 -height 447 -width 570
        mouse-move 188 197 -mask 524288 -height 447 -width 570
        mouse-move 188 196 -mask 524288 -height 447 -width 570
        mouse-move 188 195 -mask 524288 -height 447 -width 570
        mouse-move 188 191 -mask 524288 -height 447 -width 570
        mouse-move 188 190 -mask 524288 -height 447 -width 570
        mouse-move 188 190 -mask 524288 -height 447 -width 570
        mouse-move 187 190 -mask 524288 -height 447 -width 570
        mouse-move 187 190 -mask 524288 -height 447 -width 570
        mouse-move 187 189 -mask 524288 -height 447 -width 570
        mouse-move 186 189 -mask 524288 -height 447 -width 570
        mouse-move 185 189 -mask 524288 -height 447 -width 570
        mouse-move 184 189 -mask 524288 -height 447 -width 570
        mouse-move 183 189 -mask 524288 -height 447 -width 570
        mouse-move 182 190 -mask 524288 -height 447 -width 570
        mouse-move 182 191 -mask 524288 -height 447 -width 570
        mouse-move 182 192 -mask 524288 -height 447 -width 570
        mouse-move 181 193 -mask 524288 -height 447 -width 570
        mouse-move 181 195 -mask 524288 -height 447 -width 570
        mouse-move 181 197 -mask 524288 -height 447 -width 570
        mouse-move 181 198 -mask 524288 -height 447 -width 570
        mouse-move 181 200 -mask 524288 -height 447 -width 570
        mouse-move 181 201 -mask 524288 -height 447 -width 570
        mouse-move 181 202 -mask 524288 -height 447 -width 570
        mouse-move 181 203 -mask 524288 -height 447 -width 570
        mouse-move 181 204 -mask 524288 -height 447 -width 570
        get-figure "1/0" | mouse-move 1 2 -mask 524288 -height 27 -width 161
        mouse-hover 190 200 -height 447 -width 570
        mouse-move 190 198 -mask 524288 -height 447 -width 570
        mouse-move 190 197 -mask 524288 -height 447 -width 570
        mouse-move 190 196 -mask 524288 -height 447 -width 570
        mouse-move 190 195 -mask 524288 -height 447 -width 570
        mouse-move 189 195 -mask 524288 -height 447 -width 570
        mouse-move 189 194 -mask 524288 -height 447 -width 570
        mouse-move 188 194 -mask 524288 -height 447 -width 570
        mouse-move 188 193 -mask 524288 -height 447 -width 570
        mouse-move 187 193 -mask 524288 -height 447 -width 570
        mouse-move 186 192 -mask 524288 -height 447 -width 570
        mouse-move 184 192 -mask 524288 -height 447 -width 570
        mouse-move 184 191 -mask 524288 -height 447 -width 570
        mouse-move 183 191 -mask 524288 -height 447 -width 570
        mouse-move 182 191 -mask 524288 -height 447 -width 570
        mouse-move 181 191 -mask 524288 -height 447 -width 570
        mouse-move 180 191 -mask 524288 -height 447 -width 570
        mouse-move 179 191 -mask 524288 -height 447 -width 570
        mouse-move 179 192 -mask 524288 -height 447 -width 570
        mouse-move 179 193 -mask 524288 -height 447 -width 570
        mouse-move 179 194 -mask 524288 -height 447 -width 570
        mouse-move 179 195 -mask 524288 -height 447 -width 570
        mouse-move 179 196 -mask 524288 -height 447 -width 570
        mouse-move 179 197 -mask 524288 -height 447 -width 570
        mouse-move 179 198 -mask 524288 -height 447 -width 570
        mouse-move 179 199 -mask 524288 -height 447 -width 570
        mouse-move 179 200 -mask 524288 -height 447 -width 570
        mouse-move 179 200 -mask 524288 -height 447 -width 570
        mouse-move 180 200 -mask 524288 -height 447 -width 570
        mouse-move 181 200 -mask 524288 -height 447 -width 570
        mouse-move 182 201 -mask 524288 -height 447 -width 570
        mouse-move 183 201 -mask 524288 -height 447 -width 570
        mouse-move 184 201 -mask 524288 -height 447 -width 570
        mouse-move 185 201 -mask 524288 -height 447 -width 570
        mouse-move 186 201 -mask 524288 -height 447 -width 570
        mouse-move 188 203 -mask 524288 -height 447 -width 570
        mouse-move 189 203 -mask 524288 -height 447 -width 570
        mouse-move 190 203 -mask 524288 -height 447 -width 570
        mouse-move 191 203 -mask 524288 -height 447 -width 570
        mouse-move 192 203 -mask 524288 -height 447 -width 570
        mouse-move 192 202 -mask 524288 -height 447 -width 570
        mouse-move 192 200 -mask 524288 -height 447 -width 570
        mouse-move 192 199 -mask 524288 -height 447 -width 570
        mouse-move 192 198 -mask 524288 -height 447 -width 570
        mouse-move 192 197 -mask 524288 -height 447 -width 570
        mouse-move 192 196 -mask 524288 -height 447 -width 570
        mouse-move 192 195 -mask 524288 -height 447 -width 570
        mouse-move 192 194 -mask 524288 -height 447 -width 570
        mouse-move 192 192 -mask 524288 -height 447 -width 570
        mouse-move 192 191 -mask 524288 -height 447 -width 570
        mouse-move 192 190 -mask 524288 -height 447 -width 570
        mouse-move 192 189 -mask 524288 -height 447 -width 570
        mouse-move 192 188 -mask 524288 -height 447 -width 570
        mouse-move 192 187 -mask 524288 -height 447 -width 570
        mouse-move 191 187 -mask 524288 -height 447 -width 570
        mouse-move 191 186 -mask 524288 -height 447 -width 570
        mouse-move 190 186 -mask 524288 -height 447 -width 570
        mouse-move 189 186 -mask 524288 -height 447 -width 570
        mouse-move 188 186 -mask 524288 -height 447 -width 570
        mouse-move 187 186 -mask 524288 -height 447 -width 570
        mouse-move 186 186 -mask 524288 -height 447 -width 570
        mouse-move 185 186 -mask 524288 -height 447 -width 570
        mouse-move 183 186 -mask 524288 -height 447 -width 570
        mouse-move 183 186 -mask 524288 -height 447 -width 570
        mouse-move 182 187 -mask 524288 -height 447 -width 570
        mouse-move 181 189 -mask 524288 -height 447 -width 570
        mouse-move 181 190 -mask 524288 -height 447 -width 570
        mouse-move 180 190 -mask 524288 -height 447 -width 570
        mouse-move 179 194 -mask 524288 -height 447 -width 570
        mouse-move 179 196 -mask 524288 -height 447 -width 570
        mouse-move 179 198 -mask 524288 -height 447 -width 570
        mouse-move 179 199 -mask 524288 -height 447 -width 570
        mouse-move 179 201 -mask 524288 -height 447 -width 570
        mouse-move 179 203 -mask 524288 -height 447 -width 570
        mouse-move 179 203 -mask 524288 -height 447 -width 570
        mouse-move 180 203 -mask 524288 -height 447 -width 570
        mouse-move 181 203 -mask 524288 -height 447 -width 570
        mouse-move 183 203 -mask 524288 -height 447 -width 570
        mouse-move 185 203 -mask 524288 -height 447 -width 570
        mouse-move 187 203 -mask 524288 -height 447 -width 570
        mouse-move 188 203 -mask 524288 -height 447 -width 570
        mouse-move 189 203 -mask 524288 -height 447 -width 570
        mouse-move 190 203 -mask 524288 -height 447 -width 570
        mouse-move 191 203 -mask 524288 -height 447 -width 570
        mouse-move 192 198 -mask 524288 -height 447 -width 570
        mouse-move 192 196 -mask 524288 -height 447 -width 570
        mouse-move 192 192 -mask 524288 -height 447 -width 570
        mouse-move 192 191 -mask 524288 -height 447 -width 570
        mouse-move 192 190 -mask 524288 -height 447 -width 570
        mouse-move 190 189 -mask 524288 -height 447 -width 570
        mouse-move 188 189 -mask 524288 -height 447 -width 570
        mouse-move 187 189 -mask 524288 -height 447 -width 570
        mouse-move 186 189 -mask 524288 -height 447 -width 570
        mouse-move 185 189 -mask 524288 -height 447 -width 570
        mouse-move 183 189 -mask 524288 -height 447 -width 570
        mouse-move 181 189 -mask 524288 -height 447 -width 570
        mouse-move 181 189 -mask 524288 -height 447 -width 570
        mouse-move 181 191 -mask 524288 -height 447 -width 570
        mouse-move 180 192 -mask 524288 -height 447 -width 570
        mouse-move 180 194 -mask 524288 -height 447 -width 570
        mouse-move 180 195 -mask 524288 -height 447 -width 570
        mouse-move 180 196 -mask 524288 -height 447 -width 570
        mouse-move 181 196 -mask 524288 -height 447 -width 570
        mouse-move 183 196 -mask 524288 -height 447 -width 570
        mouse-move 184 196 -mask 524288 -height 447 -width 570
        mouse-move 187 196 -mask 524288 -height 447 -width 570
        mouse-move 188 196 -mask 524288 -height 447 -width 570
        mouse-move 188 195 -mask 524288 -height 447 -width 570
        mouse-move 189 194 -mask 524288 -height 447 -width 570
        mouse-move 189 192 -mask 524288 -height 447 -width 570
        mouse-move 189 191 -mask 524288 -height 447 -width 570
        mouse-move 189 189 -mask 524288 -height 447 -width 570
        mouse-move 189 188 -mask 524288 -height 447 -width 570
        mouse-move 189 187 -mask 524288 -height 447 -width 570
        mouse-move 189 185 -mask 524288 -height 447 -width 570
        mouse-move 189 184 -mask 524288 -height 447 -width 570
        mouse-move 188 184 -mask 524288 -height 447 -width 570
        mouse-move 187 184 -mask 524288 -height 447 -width 570
        mouse-move 186 184 -mask 524288 -height 447 -width 570
        mouse-move 185 184 -mask 524288 -height 447 -width 570
        mouse-move 183 184 -mask 524288 -height 447 -width 570
        mouse-move 181 184 -mask 524288 -height 447 -width 570
        mouse-move 180 184 -mask 524288 -height 447 -width 570
        mouse-move 179 184 -mask 524288 -height 447 -width 570
        mouse-move 177 184 -mask 524288 -height 447 -width 570
        mouse-move 176 185 -mask 524288 -height 447 -width 570
        mouse-move 176 186 -mask 524288 -height 447 -width 570
        mouse-move 176 187 -mask 524288 -height 447 -width 570
        mouse-move 176 188 -mask 524288 -height 447 -width 570
        mouse-move 176 189 -mask 524288 -height 447 -width 570
        mouse-move 176 190 -mask 524288 -height 447 -width 570
        mouse-move 177 191 -mask 524288 -height 447 -width 570
        mouse-move 178 192 -mask 524288 -height 447 -width 570
        mouse-move 178 193 -mask 524288 -height 447 -width 570
        mouse-move 182 196 -mask 524288 -height 447 -width 570
        mouse-move 183 196 -mask 524288 -height 447 -width 570
        mouse-move 185 197 -mask 524288 -height 447 -width 570
        mouse-move 186 198 -mask 524288 -height 447 -width 570
        mouse-move 187 198 -mask 524288 -height 447 -width 570
        mouse-move 188 198 -mask 524288 -height 447 -width 570
        mouse-move 189 198 -mask 524288 -height 447 -width 570
        mouse-move 190 198 -mask 524288 -height 447 -width 570
        mouse-move 191 197 -mask 524288 -height 447 -width 570
        mouse-move 191 196 -mask 524288 -height 447 -width 570
        mouse-move 191 195 -mask 524288 -height 447 -width 570
        mouse-move 191 194 -mask 524288 -height 447 -width 570
        mouse-move 191 193 -mask 524288 -height 447 -width 570
        mouse-move 191 192 -mask 524288 -height 447 -width 570
        mouse-move 191 191 -mask 524288 -height 447 -width 570
        mouse-move 191 190 -mask 524288 -height 447 -width 570
        mouse-move 190 190 -mask 524288 -height 447 -width 570
        mouse-move 190 189 -mask 524288 -height 447 -width 570
        mouse-move 189 189 -mask 524288 -height 447 -width 570
        mouse-move 188 188 -mask 524288 -height 447 -width 570
        mouse-move 187 188 -mask 524288 -height 447 -width 570
        mouse-move 185 188 -mask 524288 -height 447 -width 570
        mouse-move 184 187 -mask 524288 -height 447 -width 570
        mouse-move 183 187 -mask 524288 -height 447 -width 570
        mouse-move 182 187 -mask 524288 -height 447 -width 570
        mouse-move 181 187 -mask 524288 -height 447 -width 570
        mouse-move 179 187 -mask 524288 -height 447 -width 570
        mouse-move 178 187 -mask 524288 -height 447 -width 570
        mouse-move 176 187 -mask 524288 -height 447 -width 570
        mouse-move 175 187 -mask 524288 -height 447 -width 570
        mouse-move 174 187 -mask 524288 -height 447 -width 570
        mouse-move 174 189 -mask 524288 -height 447 -width 570
        mouse-move 174 190 -mask 524288 -height 447 -width 570
        mouse-move 173 195 -mask 524288 -height 447 -width 570
        mouse-move 173 200 -mask 524288 -height 447 -width 570
        mouse-move 173 201 -mask 524288 -height 447 -width 570
        mouse-move 173 202 -mask 524288 -height 447 -width 570
        mouse-move 175 204 -mask 524288 -height 447 -width 570
        mouse-move 176 204 -mask 524288 -height 447 -width 570
        mouse-move 177 205 -mask 524288 -height 447 -width 570
        mouse-move 177 206 -mask 524288 -height 447 -width 570
        mouse-move 178 206 -mask 524288 -height 447 -width 570
        mouse-move 180 206 -mask 524288 -height 447 -width 570
        mouse-move 182 206 -mask 524288 -height 447 -width 570
        mouse-move 183 206 -mask 524288 -height 447 -width 570
        mouse-move 184 205 -mask 524288 -height 447 -width 570
        mouse-move 186 204 -mask 524288 -height 447 -width 570
        mouse-move 186 203 -mask 524288 -height 447 -width 570
        mouse-move 187 202 -mask 524288 -height 447 -width 570
        mouse-move 188 200 -mask 524288 -height 447 -width 570
        mouse-move 189 199 -mask 524288 -height 447 -width 570
        mouse-move 190 198 -mask 524288 -height 447 -width 570
        mouse-move 190 196 -mask 524288 -height 447 -width 570
        mouse-move 190 195 -mask 524288 -height 447 -width 570
        mouse-move 190 194 -mask 524288 -height 447 -width 570
        mouse-move 190 194 -mask 524288 -height 447 -width 570
        mouse-move 189 194 -mask 524288 -height 447 -width 570
        mouse-move 188 194 -mask 524288 -height 447 -width 570
        mouse-move 188 193 -mask 524288 -height 447 -width 570
        mouse-move 187 193 -mask 524288 -height 447 -width 570
        mouse-move 187 193 -mask 524288 -height 447 -width 570
        mouse-move 186 194 -mask 524288 -height 447 -width 570
        mouse-move 186 195 -mask 524288 -height 447 -width 570
        mouse-move 186 196 -mask 524288 -height 447 -width 570
        mouse-move 186 195 -mask 524288 -height 447 -width 570
        mouse-move 187 195 -mask 524288 -height 447 -width 570
        mouse-move 188 195 -mask 524288 -height 447 -width 570
        mouse-move 189 195 -mask 524288 -height 447 -width 570
        mouse-move 190 195 -mask 524288 -height 447 -width 570
        mouse-move 190 193 -mask 524288 -height 447 -width 570
        mouse-move 190 192 -mask 524288 -height 447 -width 570
        mouse-move 190 191 -mask 524288 -height 447 -width 570
        mouse-move 190 190 -mask 524288 -height 447 -width 570
        mouse-move 190 189 -mask 524288 -height 447 -width 570
        mouse-move 190 188 -mask 524288 -height 447 -width 570
        mouse-move 190 187 -mask 524288 -height 447 -width 570
        mouse-move 190 184 -mask 524288 -height 447 -width 570
        mouse-move 190 183 -mask 524288 -height 447 -width 570
        mouse-move 190 182 -mask 524288 -height 447 -width 570
        mouse-move 189 181 -mask 524288 -height 447 -width 570
        mouse-move 189 180 -mask 524288 -height 447 -width 570
        mouse-move 188 180 -mask 524288 -height 447 -width 570
        mouse-move 187 179 -mask 524288 -height 447 -width 570
        mouse-move 186 178 -mask 524288 -height 447 -width 570
        mouse-move 185 177 -mask 524288 -height 447 -width 570
        mouse-move 184 177 -mask 524288 -height 447 -width 570
        mouse-move 183 177 -mask 524288 -height 447 -width 570
        mouse-move 182 178 -mask 524288 -height 447 -width 570
        mouse-move 182 179 -mask 524288 -height 447 -width 570
        mouse-move 181 179 -mask 524288 -height 447 -width 570
        mouse-move 181 181 -mask 524288 -height 447 -width 570
        mouse-move 180 182 -mask 524288 -height 447 -width 570
        mouse-move 180 184 -mask 524288 -height 447 -width 570
        mouse-move 180 185 -mask 524288 -height 447 -width 570
        mouse-move 180 189 -mask 524288 -height 447 -width 570
        mouse-move 181 190 -mask 524288 -height 447 -width 570
        mouse-move 182 192 -mask 524288 -height 447 -width 570
        mouse-move 183 192 -mask 524288 -height 447 -width 570
        mouse-move 185 192 -mask 524288 -height 447 -width 570
        mouse-move 185 192 -mask 524288 -height 447 -width 570
        get-figure "1/0" | mouse-move 1 1 -mask 524288 -height 35 -width 157
        mouse-release 185 192 button1 524288 -height 447 -width 570

        mouse-hover 185 192 -height 447 -width 570
        mouse-move 332 229 -height 447 -width 570
        get-edit-part -name newDiagram | get-edit-part -text jeoa | mouse-move 97 10 -height 50 -width 106
        get-figure "3/9" | mouse-move 105 38 -height 83 -width 133
        with [get-figure "3/9/3"] {
            mouse-move 11 7 -height 20 -width 20
            mouse-press 11 7 button1 -height 20 -width 20
        }
        get-figure "3/9/3" | mouse-press 11 7 button1 -height 20 -width 20
        get-figure "3/9" | mouse-move 118 31 -mask 524288 -height 83 -width 133
        mouse-move 456 122 -mask 524288 -height 447 -width 570
        mouse-hover 456 122 -height 447 -width 570
        get-figure "1/0" | mouse-hover 52 1 -height 90 -width 54
        mouse-move 456 120 -mask 524288 -height 447 -width 570
        mouse-move 456 119 -mask 524288 -height 447 -width 570
        mouse-move 457 119 -mask 524288 -height 447 -width 570
        mouse-move 457 118 -mask 524288 -height 447 -width 570
        mouse-move 457 117 -mask 524288 -height 447 -width 570
        mouse-move 457 116 -mask 524288 -height 447 -width 570
        mouse-move 457 115 -mask 524288 -height 447 -width 570
        mouse-move 457 113 -mask 524288 -height 447 -width 570
        mouse-move 457 112 -mask 524288 -height 447 -width 570
        mouse-move 457 101 -mask 524288 -height 447 -width 570
        mouse-move 457 100 -mask 524288 -height 447 -width 570
        mouse-move 457 99 -mask 524288 -height 447 -width 570
        mouse-move 457 98 -mask 524288 -height 447 -width 570
        mouse-move 457 97 -mask 524288 -height 447 -width 570
        mouse-move 457 96 -mask 524288 -height 447 -width 570
        mouse-move 457 95 -mask 524288 -height 447 -width 570
        mouse-move 457 93 -mask 524288 -height 447 -width 570
        mouse-move 457 84 -mask 524288 -height 447 -width 570
        mouse-move 457 83 -mask 524288 -height 447 -width 570
        mouse-move 457 82 -mask 524288 -height 447 -width 570
        mouse-move 457 81 -mask 524288 -height 447 -width 570
        mouse-move 457 80 -mask 524288 -height 447 -width 570
        mouse-move 456 78 -mask 524288 -height 447 -width 570
        mouse-move 456 75 -mask 524288 -height 447 -width 570
        mouse-move 456 75 -mask 524288 -height 447 -width 570
        mouse-move 456 74 -mask 524288 -height 447 -width 570
        mouse-move 455 74 -mask 524288 -height 447 -width 570
        mouse-move 455 73 -mask 524288 -height 447 -width 570
        mouse-move 455 71 -mask 524288 -height 447 -width 570
        mouse-move 455 70 -mask 524288 -height 447 -width 570
        mouse-move 455 69 -mask 524288 -height 447 -width 570
        mouse-move 454 69 -mask 524288 -height 447 -width 570
        mouse-move 453 69 -mask 524288 -height 447 -width 570
        mouse-move 452 69 -mask 524288 -height 447 -width 570
        mouse-move 451 69 -mask 524288 -height 447 -width 570
        mouse-move 450 69 -mask 524288 -height 447 -width 570
        mouse-move 449 69 -mask 524288 -height 447 -width 570
        mouse-move 448 69 -mask 524288 -height 447 -width 570
        mouse-move 447 69 -mask 524288 -height 447 -width 570
        mouse-move 446 69 -mask 524288 -height 447 -width 570
        mouse-move 445 69 -mask 524288 -height 447 -width 570
        mouse-move 444 69 -mask 524288 -height 447 -width 570
        mouse-move 444 67 -mask 524288 -height 447 -width 570
        mouse-move 443 67 -mask 524288 -height 447 -width 570
        mouse-move 443 66 -mask 524288 -height 447 -width 570
        mouse-move 442 66 -mask 524288 -height 447 -width 570
        mouse-move 442 65 -mask 524288 -height 447 -width 570
        mouse-move 441 65 -mask 524288 -height 447 -width 570
        mouse-move 440 63 -mask 524288 -height 447 -width 570
        mouse-move 440 62 -mask 524288 -height 447 -width 570
        mouse-move 440 61 -mask 524288 -height 447 -width 570
        mouse-move 439 61 -mask 524288 -height 447 -width 570
        mouse-move 438 60 -mask 524288 -height 447 -width 570
        mouse-move 438 59 -mask 524288 -height 447 -width 570
        mouse-move 437 58 -mask 524288 -height 447 -width 570
        mouse-move 436 57 -mask 524288 -height 447 -width 570
        mouse-move 435 57 -mask 524288 -height 447 -width 570
        mouse-move 435 56 -mask 524288 -height 447 -width 570
        mouse-move 433 56 -mask 524288 -height 447 -width 570
        mouse-move 432 55 -mask 524288 -height 447 -width 570
        mouse-move 431 55 -mask 524288 -height 447 -width 570
        mouse-move 430 55 -mask 524288 -height 447 -width 570
        mouse-move 430 54 -mask 524288 -height 447 -width 570
        mouse-move 429 54 -mask 524288 -height 447 -width 570
        mouse-move 429 54 -mask 524288 -height 447 -width 570
        mouse-move 428 54 -mask 524288 -height 447 -width 570
        mouse-move 408 44 -mask 524288 -height 447 -width 570
        mouse-move 406 43 -mask 524288 -height 447 -width 570
        mouse-move 405 42 -mask 524288 -height 447 -width 570
        mouse-move 404 42 -mask 524288 -height 447 -width 570
        mouse-move 403 41 -mask 524288 -height 447 -width 570
        mouse-move 401 41 -mask 524288 -height 447 -width 570
        mouse-move 400 41 -mask 524288 -height 447 -width 570
        mouse-move 400 40 -mask 524288 -height 447 -width 570
        mouse-move 399 40 -mask 524288 -height 447 -width 570
        mouse-move 397 40 -mask 524288 -height 447 -width 570
        mouse-move 396 39 -mask 524288 -height 447 -width 570
        mouse-move 395 39 -mask 524288 -height 447 -width 570
        mouse-move 394 38 -mask 524288 -height 447 -width 570
        mouse-move 393 38 -mask 524288 -height 447 -width 570
        mouse-move 392 38 -mask 524288 -height 447 -width 570
        mouse-move 391 37 -mask 524288 -height 447 -width 570
        mouse-move 390 37 -mask 524288 -height 447 -width 570
        mouse-move 389 37 -mask 524288 -height 447 -width 570
        mouse-move 388 37 -mask 524288 -height 447 -width 570
        mouse-move 387 36 -mask 524288 -height 447 -width 570
        mouse-move 386 36 -mask 524288 -height 447 -width 570
        mouse-move 385 35 -mask 524288 -height 447 -width 570
        mouse-move 384 35 -mask 524288 -height 447 -width 570
        mouse-move 383 35 -mask 524288 -height 447 -width 570
        mouse-move 381 34 -mask 524288 -height 447 -width 570
        mouse-move 380 34 -mask 524288 -height 447 -width 570
        mouse-move 378 34 -mask 524288 -height 447 -width 570
        mouse-move 378 33 -mask 524288 -height 447 -width 570
        mouse-move 376 32 -mask 524288 -height 447 -width 570
        mouse-move 375 32 -mask 524288 -height 447 -width 570
        mouse-move 374 31 -mask 524288 -height 447 -width 570
        mouse-move 373 31 -mask 524288 -height 447 -width 570
        mouse-move 371 31 -mask 524288 -height 447 -width 570
        mouse-move 370 31 -mask 524288 -height 447 -width 570
        mouse-move 369 30 -mask 524288 -height 447 -width 570
        mouse-move 368 30 -mask 524288 -height 447 -width 570
        mouse-move 367 30 -mask 524288 -height 447 -width 570
        mouse-move 365 30 -mask 524288 -height 447 -width 570
        mouse-move 364 30 -mask 524288 -height 447 -width 570
        mouse-move 363 30 -mask 524288 -height 447 -width 570
        mouse-move 362 30 -mask 524288 -height 447 -width 570
        mouse-move 360 30 -mask 524288 -height 447 -width 570
        mouse-move 359 30 -mask 524288 -height 447 -width 570
        mouse-move 358 30 -mask 524288 -height 447 -width 570
        mouse-move 357 30 -mask 524288 -height 447 -width 570
        mouse-move 356 30 -mask 524288 -height 447 -width 570
        mouse-move 355 30 -mask 524288 -height 447 -width 570
        mouse-move 354 30 -mask 524288 -height 447 -width 570
        mouse-move 353 30 -mask 524288 -height 447 -width 570
        mouse-move 349 29 -mask 524288 -height 447 -width 570
        mouse-move 348 29 -mask 524288 -height 447 -width 570
        mouse-move 347 29 -mask 524288 -height 447 -width 570
        mouse-move 346 29 -mask 524288 -height 447 -width 570
        mouse-move 344 28 -mask 524288 -height 447 -width 570
        mouse-move 343 28 -mask 524288 -height 447 -width 570
        mouse-move 342 28 -mask 524288 -height 447 -width 570
        mouse-move 340 28 -mask 524288 -height 447 -width 570
        mouse-move 338 28 -mask 524288 -height 447 -width 570
        mouse-move 337 28 -mask 524288 -height 447 -width 570
        mouse-move 336 28 -mask 524288 -height 447 -width 570
        mouse-move 335 27 -mask 524288 -height 447 -width 570
        mouse-move 334 27 -mask 524288 -height 447 -width 570
        mouse-move 332 27 -mask 524288 -height 447 -width 570
        mouse-move 331 27 -mask 524288 -height 447 -width 570
        mouse-move 329 27 -mask 524288 -height 447 -width 570
        mouse-move 328 27 -mask 524288 -height 447 -width 570
        mouse-move 327 27 -mask 524288 -height 447 -width 570
        mouse-move 326 26 -mask 524288 -height 447 -width 570
        mouse-move 325 26 -mask 524288 -height 447 -width 570
        mouse-move 324 26 -mask 524288 -height 447 -width 570
        mouse-move 323 26 -mask 524288 -height 447 -width 570
        mouse-move 322 26 -mask 524288 -height 447 -width 570
        mouse-move 320 26 -mask 524288 -height 447 -width 570
        mouse-move 319 26 -mask 524288 -height 447 -width 570
        mouse-move 318 26 -mask 524288 -height 447 -width 570
        mouse-move 317 26 -mask 524288 -height 447 -width 570
        mouse-move 315 26 -mask 524288 -height 447 -width 570
        mouse-move 314 26 -mask 524288 -height 447 -width 570
        mouse-move 313 26 -mask 524288 -height 447 -width 570
        mouse-move 312 26 -mask 524288 -height 447 -width 570
        mouse-move 311 26 -mask 524288 -height 447 -width 570
        mouse-move 310 26 -mask 524288 -height 447 -width 570
        mouse-move 309 26 -mask 524288 -height 447 -width 570
        mouse-move 308 26 -mask 524288 -height 447 -width 570
        mouse-move 307 26 -mask 524288 -height 447 -width 570
        mouse-move 306 26 -mask 524288 -height 447 -width 570
        mouse-move 304 26 -mask 524288 -height 447 -width 570
        mouse-move 303 26 -mask 524288 -height 447 -width 570
        mouse-move 302 26 -mask 524288 -height 447 -width 570
        mouse-move 301 26 -mask 524288 -height 447 -width 570
        mouse-move 300 26 -mask 524288 -height 447 -width 570
        mouse-move 299 26 -mask 524288 -height 447 -width 570
        mouse-move 298 26 -mask 524288 -height 447 -width 570
        mouse-move 297 26 -mask 524288 -height 447 -width 570
        mouse-move 295 26 -mask 524288 -height 447 -width 570
        mouse-move 294 26 -mask 524288 -height 447 -width 570
        mouse-move 293 26 -mask 524288 -height 447 -width 570
        mouse-move 292 26 -mask 524288 -height 447 -width 570
        mouse-move 291 26 -mask 524288 -height 447 -width 570
        mouse-move 290 26 -mask 524288 -height 447 -width 570
        mouse-move 289 26 -mask 524288 -height 447 -width 570
        mouse-move 288 26 -mask 524288 -height 447 -width 570
        mouse-move 288 27 -mask 524288 -height 447 -width 570
        mouse-move 286 27 -mask 524288 -height 447 -width 570
        mouse-move 286 27 -mask 524288 -height 447 -width 570
        mouse-move 285 28 -mask 524288 -height 447 -width 570
        mouse-move 284 28 -mask 524288 -height 447 -width 570
        mouse-move 283 28 -mask 524288 -height 447 -width 570
        mouse-move 282 29 -mask 524288 -height 447 -width 570
        mouse-move 279 29 -mask 524288 -height 447 -width 570
        mouse-move 278 30 -mask 524288 -height 447 -width 570
        mouse-move 277 30 -mask 524288 -height 447 -width 570
        mouse-move 276 30 -mask 524288 -height 447 -width 570
        mouse-move 276 31 -mask 524288 -height 447 -width 570
        mouse-move 274 31 -mask 524288 -height 447 -width 570
        mouse-move 274 32 -mask 524288 -height 447 -width 570
        mouse-move 273 32 -mask 524288 -height 447 -width 570
        mouse-move 272 32 -mask 524288 -height 447 -width 570
        mouse-move 271 33 -mask 524288 -height 447 -width 570
        mouse-move 270 34 -mask 524288 -height 447 -width 570
        mouse-move 269 34 -mask 524288 -height 447 -width 570
        mouse-move 269 35 -mask 524288 -height 447 -width 570
        mouse-move 267 35 -mask 524288 -height 447 -width 570
        mouse-move 267 36 -mask 524288 -height 447 -width 570
        mouse-move 266 37 -mask 524288 -height 447 -width 570
        mouse-move 264 38 -mask 524288 -height 447 -width 570
        mouse-move 263 38 -mask 524288 -height 447 -width 570
        mouse-move 263 38 -mask 524288 -height 447 -width 570
        mouse-move 262 39 -mask 524288 -height 447 -width 570
        mouse-move 262 40 -mask 524288 -height 447 -width 570
        mouse-move 261 40 -mask 524288 -height 447 -width 570
        mouse-move 260 42 -mask 524288 -height 447 -width 570
        mouse-move 259 43 -mask 524288 -height 447 -width 570
        mouse-move 258 43 -mask 524288 -height 447 -width 570
        mouse-move 257 45 -mask 524288 -height 447 -width 570
        mouse-move 256 45 -mask 524288 -height 447 -width 570
        mouse-move 255 46 -mask 524288 -height 447 -width 570
        mouse-move 254 48 -mask 524288 -height 447 -width 570
        mouse-move 253 49 -mask 524288 -height 447 -width 570
        mouse-move 253 49 -mask 524288 -height 447 -width 570
        mouse-move 252 50 -mask 524288 -height 447 -width 570
        mouse-move 250 53 -mask 524288 -height 447 -width 570
        mouse-move 249 54 -mask 524288 -height 447 -width 570
        mouse-move 247 55 -mask 524288 -height 447 -width 570
        mouse-move 247 56 -mask 524288 -height 447 -width 570
        mouse-move 246 56 -mask 524288 -height 447 -width 570
        mouse-move 245 57 -mask 524288 -height 447 -width 570
        mouse-move 245 58 -mask 524288 -height 447 -width 570
        mouse-move 244 59 -mask 524288 -height 447 -width 570
        mouse-move 244 60 -mask 524288 -height 447 -width 570
        mouse-move 243 61 -mask 524288 -height 447 -width 570
        mouse-move 243 62 -mask 524288 -height 447 -width 570
        mouse-move 242 62 -mask 524288 -height 447 -width 570
        mouse-move 242 65 -mask 524288 -height 447 -width 570
        mouse-move 241 66 -mask 524288 -height 447 -width 570
        mouse-move 241 67 -mask 524288 -height 447 -width 570
        mouse-move 240 68 -mask 524288 -height 447 -width 570
//        get-figure "0/1/0/0/0/0" | mouse-move 33 39 -mask 524288 -height 50 -width 100
        get-edit-part -name newDiagram | get-edit-part -text "jo`" | mouse-release 33 39 button1 524288 -height 50 
            -width 106
//        get-figure "0/1/0/0/0/0" | mouse-release 33 39 button1 524288 -height 50 -width 100
    }
    // Preved medved!

    
    with [get-diagram -index 1] {
        mouse-move 104 281 -height 447 -width 570
        mouse-hover 104 281 -height 447 -width 570
        mouse-move 14 376 -height 447 -width 570
    }
}

    proc foo [val a] {}
    
    
    foo 4
