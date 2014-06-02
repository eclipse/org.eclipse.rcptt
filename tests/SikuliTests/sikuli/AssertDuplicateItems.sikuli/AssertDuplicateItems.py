list=findAll("Project1Chea.png")
for x in findAll("Project1Chea.png"):
    click(x)
    r=find("caption-1.png").left()
    b=r.find("W.png")
    click(b)
    click("Add.png")


