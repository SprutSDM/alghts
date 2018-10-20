from tkinter import *

width = 192
depth = 2
step = width / 3
for i in range(0, depth):
    step /= 2
x, y = 50, 50


def drawRight(depth):
    if (depth == 0):
        drawPartRight()
        return
    drawRight(depth - 1)
    mv_dr(step, step)
    drawDown(depth - 1)
    mv_dr(step, 0)
    drawUp(depth - 1)
    mv_dr(step, -step)
    drawRight(depth - 1)

def drawDown(depth):
    if (depth == 0):
        drawPartDown()
        return
    drawDown(depth - 1)
    mv_dr(-step, step)
    drawLeft(depth - 1)
    mv_dr(0, step)
    drawRight(depth - 1)
    mv_dr(step, step)
    drawDown(depth - 1)

def drawLeft(depth):
    if (depth == 0):
        drawPartLeft()
        return
    drawLeft(depth - 1)
    mv_dr(-step, -step)
    drawUp(depth - 1)
    mv_dr(-step, 0)
    drawDown(depth - 1)
    mv_dr(-step, step)
    drawLeft(depth - 1)

def drawUp(depth):
    if (depth == 0):
        drawPartUp()
        return
    drawUp(depth - 1)
    mv_dr(step, -step)
    drawRight(depth - 1)
    mv_dr(0, -step)
    drawLeft(depth - 1)
    mv_dr(-step, -step)
    drawUp(depth - 1)

def drawPartRight():
    global x, y
    w.create_line(x, y, x + step, y + step)
    w.create_line(x + step, y + step, x + step * 2, y + step)
    w.create_line(x + step * 2, y + step, x + step * 3, y)
    x += step * 3

def drawPartDown():
    global x, y
    w.create_line(x, y, x - step, y + step)
    w.create_line(x - step, y + step, x - step, y + step * 2)
    w.create_line(x - step, y + step * 2, x, y + step * 3)
    y += step * 3    

def drawPartLeft():
    global x, y
    w.create_line(x, y, x - step, y - step)
    w.create_line(x - step, y - step, x - step * 2, y - step)
    w.create_line(x - step * 2, y - step, x - step * 3, y)
    x -= step * 3

def drawPartUp():
    global x, y
    w.create_line(x, y, x + step, y - step)
    w.create_line(x + step, y - step, x + step, y - step * 2)
    w.create_line(x + step, y - step * 2, x, y - step * 3)
    y -= step * 3

def mv_dr(dx, dy):
    global x, y
    w.create_line(x, y, x + dx, y + dy)
    x += dx
    y += dy

def redraw(event=None):
    global step
    depth = int(ent.get())
    width = 192
    step = width / 3
    for i in range(0, depth):
        step /= 2
    w.create_rectangle(0, 0, 500, 500, fill='white')
    drawRight(depth=depth)
    
    mv_dr(step, step)
    drawDown(depth=depth)
    mv_dr(-step, step)
    drawLeft(depth=depth)
    mv_dr(-step, -step)
    drawUp(depth=depth)
    
    mv_dr(step, -step)
    
    

root = Tk()
ent = Entry(root, width=30, fg='black', textvariable=StringVar(root, value='2')) 
ent.pack(side='top')

btn = Button(root, text='Draw', width=3, height=1, bg='white', fg='black')
btn.bind('<Button-1>', redraw)
btn.pack(side='top')

w = Canvas(root, width=500, height=500)
w.pack()

redraw()

root.mainloop()
