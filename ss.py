import pickle
import json

Model = pickle.load(open('finalized_model.pkl', 'rb'))
# y = Model.run('x.json', 'output.json')
