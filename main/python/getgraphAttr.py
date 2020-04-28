def callit(user_input,path):

    #Libraries
    import datetime
    import requests
    import pandas as pd
    import numpy as np
    import matplotlib.pyplot as plt
    import pandas_datareader as web
    from scipy import stats
    import sys
    plt.style.use("fivethirtyeight")

    #Functions

    #def convertit(s):
        #return("".join([chr(ord(a)+32) for a in s]))
        
        
    #Code 
        
    #Get the data

    currentDT = datetime.datetime.now()
    end=str(currentDT.year)+'-'+str(currentDT.month)+'-'+str(currentDT.day)
    start=str(currentDT.year)+'-'+str(currentDT.month-1)+'-'+str(currentDT.day)

    df = web.DataReader(str(user_input), data_source='yahoo',start=start,end=end)
    df = pd.DataFrame(data=df['Close'])
    df.columns=['y']
    df['ds']=df.index

    # Moving Averages a corto plazo

    plt.figure(figsize=(20,10))
    #rolling_mean = df.y.rolling(window=10).mean()
    #rolling_mean2 = df.y.rolling(window=50).mean()
    plt.plot(df.ds, df.y, label=user_input)

    #plt.plot(df.ds, rolling_mean, label=str(user_input)+' 10 Day SMA', color='orange')
    #plt.plot(df.ds, rolling_mean2, label=str(user_input)+' 50 Day SMA', color='magenta')
    plt.legend(loc='upper left')
    #plt.show()

    #plt.savefig('C:/Users/Jesus/AndroidStudioProjects/SubastaPublica/app/src/main/res/drawable/'+convertit(str(user_input))+'.png',orientation='landscape')
    plt.savefig(str(path)+'/'+str(user_input)+'.png')


    return(user_input)

